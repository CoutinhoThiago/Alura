package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.sitacao.Aprovado;
import br.com.alura.loja.orcamento.sitacao.SituacaoOrcamento;

public class Orcamento 
{
	private BigDecimal valor;
	private int quantidadeDeItens;
	private SituacaoOrcamento situacao;
	
	public Orcamento(BigDecimal valor, int quantidadeDeItens)
	{
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
	}
	
	public void aplicarDescontoExtra()
	{
		BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}
	public int getQuantidadeDeItens() 
	{
		return quantidadeDeItens;
	}
	public BigDecimal getValor()
	{
		return valor;
	}

	public void setSituacao(SituacaoOrcamento situacao) 
	{
		this.situacao = situacao;
	}
}