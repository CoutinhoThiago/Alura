package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.Http.HttpAdapter;

public class RegistroDeOrcamento 
{
	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http)
	{
		this.http = http;
	}
	public void registrar(Orcamento orcamento)
	{
		// Chamada HTTP para a API externa
		// URL Connection -> Proprio Java
		// Http Client -> Apache
		// lib Rest
		if (!orcamento.isFinalizado())
		{
			throw new DomainException("orcamento não finalizado");
		}
		
		String url = "http://api.exterma/orcamento";
		Map<String, Object> dados = Map.of(
			"valor", orcamento.getValor(),
			"quantidadeItens", orcamento.getQuantidadeDeItens());
		http.post(url,dados);
	}
}
