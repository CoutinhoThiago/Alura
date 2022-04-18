package br.com.alura;

import java.util.List;

public class TestaCursos 
{
	public static void main(String[] args) 
	{
        Cursos javaColecoes = new Cursos("Dominando as coleções do Java",
                "Paulo Silveira");

        List<Aula> aulas = javaColecoes.getAulas();        
        System.out.println(aulas);
        
        //javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
        //System.out.println(aulas);
        
        //System.out.println(javaColecoes.getAulas());
        //System.out.println(aulas == javaColecoes);
        //System.out.println(aulas == javaColecoes.getAulas());
        
        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        System.out.println(javaColecoes.getAulas());
    }
}
