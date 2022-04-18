package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodoEntreReajustes implements ValidacaoReajuste
{
	public void valdar(Funcionario funcionario, BigDecimal aumento) 
	{
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		
		long mesesDesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if (mesesDesUltimoReajuste < 6)
		{
			throw new ValidacaoException("Intervalo entre reajustes deve ser minimo 6 meses!");
		}
	}
}
