package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco 
{
	private static Integer chaveSequencial = 1;
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		lista.add(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa2.setNome("Caelum");

		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) 
	{
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas()
	{
		return Banco.lista;
	}

	public void remove(Integer id) 
	{
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext())
		{
			Empresa emp = it.next();
			
			if (emp.getId() == id)
			{
				it.remove();
			}
		}	
	}

	public Empresa buscaEmpresa(Integer id) 
	{
		for (Empresa empresa : lista) 
		{
			if(empresa.getId() == id)
			{
				return empresa;
			}
		}
		return null;
	}
}
