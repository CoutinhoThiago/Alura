package br.com.alura.loja;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHndler;
import br.com.alura.loja.pedido.Pedido;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestaPedido 
{
	public static void main(String[] args) 
	{
		String cliente = "Rodrigo";
		BigDecimal valorOrcamento = new BigDecimal("300");
		int quantidadeDeItens = Integer.parseInt("2");
		
		GeraPedido geradpr = new GeraPedido(cliente, valorOrcamento, quantidadeDeItens);
		GeraPedidoHndler handler = new GeraPedidoHndler(
				Arrays.asList(
						new SalvarPedidoNoBancoDeDados(), 
						new EnviarEmail(),
						new SalvarPedidoNoBancoDeDados(),
						new LogDePedido()
						));
				
		handler.execute(geradpr);
	}
}
