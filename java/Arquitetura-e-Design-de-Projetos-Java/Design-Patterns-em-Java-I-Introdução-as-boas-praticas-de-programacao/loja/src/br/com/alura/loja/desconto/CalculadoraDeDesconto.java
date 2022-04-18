package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeDesconto 
{
	public BigDecimal calcular(Orcamento orcamento)
	{
		Desconto cadeiaDeDescontoS = new DescontoParaOrcamentoComMaisDeCincoItens(
						new DescontoParaOrcamentoComValorMaiorQueQuinhentos(
								new SemDesconto()));
		
		
		return cadeiaDeDescontoS.calcular(orcamento);
	}
}
