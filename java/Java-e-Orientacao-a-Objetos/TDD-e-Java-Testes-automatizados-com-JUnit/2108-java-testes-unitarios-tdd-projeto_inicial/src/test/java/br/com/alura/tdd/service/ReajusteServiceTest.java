package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest 
{
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar()
	{
		System.out.println("inicializa");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void fimnalizar()
	{
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void antesDeTodos()
	{
		System.out.println("ANTES DE TODOS OS TESTES");
	}
	@AfterAll
	public static void DepoisDeTodos()
	{
		System.out.println("DEPOIS DE TODOS OS TESTES");
	}
	
	@Test
	public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar()
	{	
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom()
	{	
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo()
	{	
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
	}
	
}
