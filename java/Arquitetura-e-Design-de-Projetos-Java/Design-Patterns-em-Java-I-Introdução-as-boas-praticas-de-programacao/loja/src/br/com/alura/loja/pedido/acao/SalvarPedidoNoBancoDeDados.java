package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedidos
{
	public void executarAcao(Pedido pedido)
	{
		System.out.println("Salvar pedido no banco de dados");
	}
}
