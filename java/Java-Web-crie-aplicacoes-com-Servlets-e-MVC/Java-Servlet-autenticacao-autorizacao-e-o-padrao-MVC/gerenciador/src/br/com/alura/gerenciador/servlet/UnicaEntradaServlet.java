package br.com.alura.gerenciador.servlet;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("listaEmpresa")) {
			System.out.println("Listando empresas");
		}
	}

}
