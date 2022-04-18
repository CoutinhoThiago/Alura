package br.com.alura.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = null;
        alunoEncontrado = buscaAlunoPeloId(aluno);
        editaAluno(aluno, alunoEncontrado);
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a: alunos) {
            if(a.getId() == aluno.getId()) {
                aluno = a;
            }
        }
        return aluno;
    }

    private void editaAluno(Aluno aluno, Aluno alunoEncontrado) {
        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    public List<Aluno> todosOsAlunos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        alunos.remove(alunoDevolvido);
    }
}
