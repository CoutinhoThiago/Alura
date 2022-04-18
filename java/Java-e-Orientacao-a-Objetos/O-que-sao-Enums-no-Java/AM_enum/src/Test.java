
public class Test 
{
	public static void main(String[] args) 
	{
		/*System.out.println(Thread.MAX_PRIORITY);
				
		Thread t = new Thread(() -> System.out.println("rodando . . ."));
		
		t.setPriority(Thread.MAX_PRIORITY);
		
		t.start();*/
		
		Prioridade pMin = Prioridade.MIN;
		Prioridade pNormal = Prioridade.NORMAL;
		Prioridade pMax = Prioridade.MAX;
		
		System.out.println(pMin.ordinal());
		System.out.println(pNormal.ordinal());
		System.out.println(pMax.ordinal());
		
		System.out.println(pMin.name());
		System.out.println(pNormal.name());
		System.out.println(pMax.name());
		
		System.out.println(pMin.getValor());
		System.out.println(pNormal.getValor());
		System.out.println(pMax.getValor());
		
		System.out.println(pMin);
		System.out.println(pNormal);
		System.out.println(pMax);
	} 
}
