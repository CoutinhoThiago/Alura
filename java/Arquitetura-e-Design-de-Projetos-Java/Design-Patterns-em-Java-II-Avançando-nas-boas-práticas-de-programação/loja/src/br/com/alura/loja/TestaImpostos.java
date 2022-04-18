package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalculadoraDeImposto;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.imposto.Imposto;
import br.com.alura.loja.orcamento.Orcamento;

public class TestaImpostos 
{
	public static void main(String[] args) 
	{
		//Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		//CalculadoraDeImposto calculardora = new CalculadoraDeImposto();
		//System.out.println(calculardora.calcular(orcamento, new Imposto()));
		
		Orcamento orcamento = new Orcamento();

		Imposto imposto = new ICMS(new ISS(null));
		System.out.println(imposto.calcular(orcamento));
	}
}
