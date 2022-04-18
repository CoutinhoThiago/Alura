package br.com.alura.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class FormularioDeCadasroDeAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText camopoNome;
    private EditText camopoTelefone;
    private EditText camopoEmal;
    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_de_cadasro_de_aluno);

        setTitle(TITULO_APPBAR);

        inicializacaoDeCampos();

        botaoSalvar();
    }

    private void botaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_nome_formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view){
                Aluno alunoCriado = criarAluno();
                salva(alunoCriado);
            }
        });
    }

    private void inicializacaoDeCampos() {
        camopoNome = findViewById(R.id.activity_nome_formulario_nome);
        camopoTelefone = findViewById(R.id.activity_nome_formulario_telefone);
        camopoEmal = findViewById(R.id.activity_nome_formulario_email);
    }

    private void salva(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
    }

    @NonNull
    private Aluno criarAluno() {
        String nome = camopoNome.getText().toString();
        String telefone = camopoTelefone.getText().toString();
        String emal = camopoEmal.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, emal);
        return alunoCriado;
    }
}