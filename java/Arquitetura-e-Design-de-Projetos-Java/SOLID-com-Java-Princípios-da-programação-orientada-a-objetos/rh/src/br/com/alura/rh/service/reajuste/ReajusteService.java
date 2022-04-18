package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ReajusteService 
{
	private List<ValidacaoReajuste> validacoes;
	public ReajusteService(List<ValidacaoReajuste> validacoes)
	{
		this.validacoes = validacoes;
	}
	public void ReajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento)
	{
		this.validacoes.forEach(v -> v.valdar(funcionario, aumento));
		
		//ValidacaoPercentualReajuste valdarPercentualReajuste = new ValidacaoPercentualReajuste();
		//ValidacaoPeriodoEntreReajustes validacaoPeriodoEntreReajustes = new ValidacaoPeriodoEntreReajustes();
		
		//valdarPercentualReajuste(funcionario, aumento);
		//validacaoPeriodoEntreReajustes(funcionario, aumento);
		
		BigDecimal SalarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(SalarioReajustado);
	}
}
