package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet
{
	/*public static void main(String[] args) 
	{ 
	    OiMundoServlet servlet = new OiMundoServlet();
	    servlet.service(req, resp);
	}*/ 
	
	public OiMundoServlet() 
	{ 
        System.out.println("Criando Oi Mundo Servlet");
    } 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		

		out.println("<html>");
			out.println("<boddy>");
				out.println("oi mundo parabens vc escreveu o primeiro servlet");
			out.println("</boddy>");
		out.println("</html>");
		
		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
