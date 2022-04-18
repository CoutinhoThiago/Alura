
public enum Prioridade 
{
	MIN(10),
	NORMAL(100),
	MAX(1000);
	
	private int valor;
	
	Prioridade(int valor)
	{
		this.valor = valor;
	}
	
	public int getValor()
	{
		return this.valor;
	}
}
