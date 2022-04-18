package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Cursos 
{
	private String nome;
    private String instrutor;
    //private List<Aula> aulas = new LinkedList<Aula>();

    private List<Aula> aulas = new ArrayList<Aula>();
    private Set<Aluno> alunos = new HashSet<>();
    //private Set<Aluno> alunos = new LinkedHashSet<>();
    //private Set<Aluno> alunos = new TreeHashSet<>();
    
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
    
    Set<Aluno> alunosSincronizados = Collections.synchronizedSet(alunos);
    
    public Cursos(String nome, String instrutor) 
    {
		//super();
		this.nome = nome;
		this.instrutor = instrutor;
	}
    
    public String getNome() 
    {
    	return nome;
	}
    public String getInstrutor() 
    {
    	return instrutor;
	}
    
    public List<Aula> getAulas() 
    {
        return Collections.unmodifiableList(aulas);
    }
    
    public void adiciona(Aula aula) 
    {
        this.aulas.add(aula);
        //this.tempoTotal += aula.getTempo();
    }
    
    //public int getTempoTotal() 
    //{
    //    int tempoTotal = 0;
    //    for (Aula aula : aulas) 
    //    {
    //        tempoTotal += aula.getTempo();
    //    }
    //    return tempoTotal;
    //}
    
    public int getTempoTotal() 
    {
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }
    
    @Override
    public String toString() 
    {
        return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal()
                + ", aulas: + " + this.aulas + "]";
    }
    
    public void matricula(Aluno aluno)
    {
    	// adiciona no Set de alunos
        this.alunos.add(aluno);
        // cria a relação no Map
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }
    
    public Set<Aluno> getAlunos() 
    {
        return Collections.unmodifiableSet(alunos);
    }

	public boolean estaMatriculado(Aluno aluno) 
	{
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) 
	{
		//for(Aluno aluno : alunos)
		//{
		//	if(aluno.getNumeroMatricula() == numero);
		//	{
		//		return aluno;
		//	}
		//}
		//throw new NoSuchElementException("maricula nao encontrada" + numero);
		
		return matriculaParaAluno.get(numero);
	}
}
