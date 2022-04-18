package br.com.alura.tdd;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTestes 
{
	public static void main(String[] args) 
	{
		/*Calculadora calculadora = new Calculadora();
		
		int soma = calculadora.somar(3, 7);
		System.out.println(soma);
		
		soma = calculadora.somar(0, 3);
		System.out.println(soma);
		
		soma = calculadora.somar(3, 3);
		System.out.println(soma);
		
		soma = calculadora.somar(0, 0);
		System.out.println(soma);
		
		soma = calculadora.somar(3, -2);
		System.out.println(soma);*/
	}
	
	@Test
	public void deveSomarDoisNumerosPositivos()
	{
		Calculadora calculadora = new Calculadora();
		
		int soma = calculadora.somar(3, 7);
		//System.out.println(soma);
		
		Assert.assertEquals(10, soma);
	}
}
