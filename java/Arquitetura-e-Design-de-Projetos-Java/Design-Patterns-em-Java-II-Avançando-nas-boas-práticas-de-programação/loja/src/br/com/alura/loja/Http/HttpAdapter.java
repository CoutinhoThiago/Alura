package br.com.alura.loja.Http;

import java.util.Map;

public interface HttpAdapter 
{
	 void post(String url, Map<String, Object> dados);
}
