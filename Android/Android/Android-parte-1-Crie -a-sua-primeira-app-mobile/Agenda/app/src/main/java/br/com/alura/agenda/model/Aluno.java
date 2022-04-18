package br.com.alura.agenda.model;

import androidx.annotation.NonNull;

public class Aluno {
    private String nome;
    private final String telefone;
    private final String emal;

    public Aluno(String nome, String telefone, String emal) {
        this.nome = nome;
        this.telefone = telefone;
        this.emal = emal;
    }

    @NonNull
    @Override
    public String toString() {
        return  nome;
    }
}
