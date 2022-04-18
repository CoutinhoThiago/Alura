package br.com.alura;

public class Aula implements Comparable<Aula>
{
	private String titulo;
    private int tempo;
    
	public Aula(String titulo, int tempo) 
	{
		//super(); //implicito no java
		this.titulo = titulo;
		this.tempo = tempo;
	}
	
	public int getTempo() 
	{
		return tempo;
	}
	
	public String getTitulo() 
	{
		return titulo;
	}
	
	@Override
    public String toString() 
	{
        return "[Aula: " + this.titulo + ", " + this.tempo + " minutos]";
    }

	@Override
	public int compareTo(Aula outraAula) 
	{
		//if(this.titulo.compareTo(outraAula.titulo) > 0)
		//{
		//	return -1;
		//}
		//return 0;
		
		return this.titulo.compareTo(outraAula.titulo);
	}
}
