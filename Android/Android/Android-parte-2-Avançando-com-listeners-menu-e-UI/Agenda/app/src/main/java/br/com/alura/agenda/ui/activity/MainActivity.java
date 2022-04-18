package br.com.alura.agenda.ui.activity;

import static br.com.alura.agenda.ui.activity.ConstantesActivity.CHAVE_ALUNO;
import static br.com.alura.agenda.ui.activity.ConstantesActivity.TITULO_APPBAR;

import android.content.Intent;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class MainActivity extends AppCompatActivity {
    private final AlunoDAO dao = new AlunoDAO();
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(TITULO_APPBAR);
        ConfiguraFabNovoAluno();
        ConfiguraLista();


        Toast.makeText(this, "Bem vindo Thiago Coutinho", Toast.LENGTH_LONG).show();

        //dao.salva(new Aluno(teste, 999999, testeemail@test.com));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_de_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(itemId == R.id.activity_main_lista_de_alunos_menu_remover) {
            Aluno alunoEsolhido = adapter.getItem(menuInfo.position);
            remove(alunoEsolhido);
        }
        if(itemId == R.id.activity_main_lista_de_alunos_menu_editar) {
            Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
            abreFormukarioModoEditarAluno(alunoEscolhido);
        }
        return super.onContextItemSelected(item);
    }

    private void ConfiguraFabNovoAluno() {
        FloatingActionButton botaoAdicionarAluno = findViewById(R.id.activity_main_fab_novo_aluno);
        botaoAdicionarAluno.setOnClickListener(view -> {
            abreFormularioModoInserirAluno();
                });
    }

    private void abreFormularioModoInserirAluno() {
        startActivity(new Intent(
                this,
                FormularioDeCadasroDeAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.clear();
        adapter.addAll(dao.todosOsAlunos());
    }

    private void ConfiguraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        
        configuraAdaper(listaDeAlunos);
        ConfiguraListenerDeClickItemPorItem(listaDeAlunos);
        configuraListenerDeClickLongoPorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void configuraListenerDeClickLongoPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);

                return false;
            }
        });
    }

    private void remove(Aluno alunoEscolhido) {
        dao.remove(alunoEscolhido);
        adapter.remove(alunoEscolhido);
    }

    private void ConfiguraListenerDeClickItemPorItem(ListView ListaDeAlunos) {
        ListaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao); //alunos.get(posicao);
                abreFormukarioModoEditarAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormukarioModoEditarAluno(Aluno alunoEscolhido) {
        Intent vaiParaFormularioActivity = new Intent(MainActivity.this, FormularioDeCadasroDeAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdaper(ListView ListaDeAlunos) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1);
        ListaDeAlunos.setAdapter(adapter);
    }
}
