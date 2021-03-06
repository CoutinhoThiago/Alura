import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings 
{
	public static void main(String[] args) 
	{
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("alura online");
		palavras.add("casa do c?digo");
		palavras.add("caelum");
		
		//Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		
		//Collections.sort(palavras);
		//palavras.sort(comparador);
			//palavras.sort(new Comparator<String>()
			//{
			//	@Override
			//	public int compare(String s1, String s2) 
			//    {
			//    	if (s1.length() < s2.length()) 
			//    	{
			//            return -1;
			//    	}
			//      if (s1.length() > s2.length()) 
			//        {
			//            return 1;
			//       }
			//        return 0;
			//   }
			//});
				//palavras.sort((s1, s2)  -> {
				//    	if (s1.length() < s2.length()) 
				//    	{
				//            return -1;
				//    	}
				//        if (s1.length() > s2.length()) 
				//        {
				//            return 1;
				//       }
				//        return 0;
				//});
				
					//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
					
						palavras.sort(Comparator.comparing(s -> s.length()));
						palavras.sort(Comparator.comparing(String::length));
		
		System.out.println(palavras);
		
		//palavras.forEach(new Consumer<String>()
		//{
		//	@Override
		//	public void accept (String s)
		//	{
		//		System.out.println(s);
		//	}
		//});
		
			//palavras.forEach((String s) -> {
			//	System.out.println(s);
			//});
			
				//palavras.forEach((s) -> {
				//	System.out.println(s);
				//});
				
					//palavras.forEach((s) -> System.out.println(s));

						palavras.forEach(System.out::println);
		
		//for (String p : palavras) 
		//{
		//	System.out.println(p);
		//}
		
		//Consumer<String> consumidor = null;
		//palavras.forEach(consumidor);
	}
}

//class ImprimeNaLinha implements Consumer<String>
//{
//  @Override
//	public void accept (String s)
//	{
//		System.out.println(s);
//	}
//}

/*class ComparadorDeStringPorTamanho implements Comparator<String> 
{
    public int compare(String s1, String s2) 
    {
    	if (s1.length() < s2.length()) 
    	{
            return -1;
    	}
        if (s1.length() > s2.length()) 
        {
            return 1;
        }
        return 0;
    }
}*/