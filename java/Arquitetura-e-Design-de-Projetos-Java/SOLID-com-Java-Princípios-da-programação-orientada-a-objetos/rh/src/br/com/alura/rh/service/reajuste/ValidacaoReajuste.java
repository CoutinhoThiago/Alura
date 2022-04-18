package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacaoReajuste 
{
	void valdar(Funcionario funcionario, BigDecimal aumento);s
}
