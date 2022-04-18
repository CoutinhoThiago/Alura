package br.com.alura.loja.pedido;

import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;

public class Pedido 
{
	private String cliente;
	private LocalDateTime data;
	private Orcamento orcamento;
	
	public Pedido(String cliente, LocalDateTime data, Orcamento orcamento) 
	{
		this.cliente = cliente;
		this.data = data;
		this.orcamento = orcamento;
	}


	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}
	public void setData(LocalDateTime data) 
	{
		this.data = data;
	}
	public void setOrcamento(Orcamento orcamento)
	{
		this.orcamento = orcamento;
	}
}
