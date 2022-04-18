package br.com.alura.agenda.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class MainActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle(TITULO_APPBAR);

        ConfiguraFabNovoAluno();

        Toast.makeText(this, "Bem vindo Thiago Coutinho", Toast.LENGTH_LONG).show();
    }

    private void ConfiguraFabNovoAluno() {
        FloatingActionButton botaoAdicionarAluno = findViewById(R.id.activity_main_fab_novo_aluno);
        botaoAdicionarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(
                this,
                FormularioDeCadasroDeAlunoActivity.class));
    }

    @Override
    protected void onResume(){ super.onResume();

        ConfiguraLista(dao);
    }

    private void ConfiguraLista(AlunoDAO dao) {
        ListView ListaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        ListaDeAlunos.setAdapter(new ArrayAdapter<Aluno>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                dao.todosOsAlunos()));
    }
}
