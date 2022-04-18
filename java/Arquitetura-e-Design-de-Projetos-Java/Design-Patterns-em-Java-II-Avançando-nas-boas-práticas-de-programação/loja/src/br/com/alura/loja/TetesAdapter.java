package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.Http.HttpAdapter;
import br.com.alura.loja.Http.HttpClient;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

public class TetesAdapter 
{
	public static void main(String[] args) 
	{
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento (new HttpClient());
		registro.registrar(orcamento);
	}
}
