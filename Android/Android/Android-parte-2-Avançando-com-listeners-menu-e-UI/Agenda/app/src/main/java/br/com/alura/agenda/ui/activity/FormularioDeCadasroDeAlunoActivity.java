package br.com.alura.agenda.ui.activity;

import static br.com.alura.agenda.ui.activity.ConstantesActivity.CHAVE_ALUNO;
import static br.com.alura.agenda.ui.activity.ConstantesActivity.TITULO_APPBAR_EDITAR_ALUNO;
import static br.com.alura.agenda.ui.activity.ConstantesActivity.TITULO_APPBAR_NOVO_ALUNO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class FormularioDeCadasroDeAlunoActivity extends AppCompatActivity {

    private EditText camopoNome;
    private EditText camopoTelefone;
    private EditText camopoEmal;
    final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_de_cadasro_de_aluno);
        inicializacaoDeCampos();
        //botaoSalvar();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_frmulario_aluno_menu_salvar) {
            finalizarFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITAR_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        }
        else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        camopoNome.setText(aluno.getNome());
        camopoTelefone.setText(aluno.getTelefone());
        camopoEmal.setText(aluno.getEmal());
    }

//    private void botaoSalvar() {
//        Button botaoSalvar = findViewById(R.id.activity_nome_formulario_botao_salvar);
//        botaoSalvar.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view){
//                finalizarFormulario();
//            }
//        });
//    }

    private void finalizarFormulario() {
        preencheAluno();
        if (aluno.temIdValido()) {
            dao.edita(aluno);
        }
        else {
            dao.salva(aluno);
        }
        finish();
    }

    private void inicializacaoDeCampos() {
        camopoNome = findViewById(R.id.activity_nome_formulario_nome);
        camopoTelefone = findViewById(R.id.activity_nome_formulario_telefone);
        camopoEmal = findViewById(R.id.activity_nome_formulario_email);
    }

    @NonNull
    private void preencheAluno() {
        String nome = camopoNome.getText().toString();
        String telefone = camopoTelefone.getText().toString();
        String emal = camopoEmal.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(emal);
        Aluno alunoCriado = new Aluno(nome, telefone, emal);
    }
}