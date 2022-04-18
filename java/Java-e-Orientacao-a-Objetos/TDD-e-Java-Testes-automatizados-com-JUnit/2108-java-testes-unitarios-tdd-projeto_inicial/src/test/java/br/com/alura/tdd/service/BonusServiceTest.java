package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() 
	{
		BonusService service = new BonusService();
		
		//assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
		//fail("Not yet implemented");
		
		try 
		{
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("nao deu exeption");
		}
		catch (Exception e)
		{
			assertEquals("Funcionario com salario maior que 10000 reais nao tem bonus", e.getMessage());
		}
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() 
	{
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		//fail("Not yet implemented");
		
		assertEquals(new BigDecimal("250.0"), bonus);
	}
}
