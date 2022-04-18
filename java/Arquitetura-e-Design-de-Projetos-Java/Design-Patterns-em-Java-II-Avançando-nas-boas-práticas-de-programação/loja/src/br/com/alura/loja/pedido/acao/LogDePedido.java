package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedidos
{
	@Override
	public void executarAcao(Pedido pedido)
	{
		System.out.println("pedido foi gerado " + pedido);
	}
}
