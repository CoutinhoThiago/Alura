package br.com.alura.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja.orcamento.sitacao.Aprovado;
import br.com.alura.loja.orcamento.sitacao.EmAnalise;
import br.com.alura.loja.orcamento.sitacao.Finalizado;
import br.com.alura.loja.orcamento.sitacao.SituacaoOrcamento;

public class Orcamento implements Orcavel 
{
	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	
	private List<Orcavel> itens;
	
	public Orcamento()
	{
		this.valor = BigDecimal.ZERO;
		this.itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}
	
	public void aplicarDescontoExtra()
	{
		BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}
	public int getQuantidadeDeItens() 
	{
		return itens.size();
	}
	public BigDecimal getValor()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			throw new RuntimeException(e);
		}
		return valor;
	}

	public void setSituacao(SituacaoOrcamento situacao) 
	{
		this.situacao = situacao;
	}

	public boolean isFinalizado() 
	{
		return situacao instanceof Finalizado;
	}
	
	public void aprovar() 
	{
		this.situacao.aprovar(this);
	}
	
	public void reprovar() 
	{
		this.situacao.reprovar(this);
	}
	
	public void finalizar() 
	{
		this.situacao.finalizar(this);
	}
	
	public void adicionarItem(Orcavel item)
	{
		this.valor = valor.add(item.getValor());
		this.itens.add(item);
	}
}