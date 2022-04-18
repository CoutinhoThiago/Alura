package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.sitacao.SituacaoOrcamento;

public class GeraPedido
{
	private String cliente;
	
	private BigDecimal valorOrcamento;
	private int quantidadeDeItens;
	
	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeDeItens) 
	{
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeDeItens = quantidadeDeItens;
	}
	
	public void executa()
	{
		
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public String getCliente() {
		return cliente;
	}

	public int getQuantidadeDeItens() {
		return quantidadeDeItens;
	}
}
