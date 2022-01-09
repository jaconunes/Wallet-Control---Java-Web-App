package wallet.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Conta;

/**
 * Servlet implementation class bucarContasSelectController
 */
@WebServlet("/buscarContasSelectController")
public class buscarContasSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public buscarContasSelectController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		
		String botaoAdicionar = request.getParameter("adicionarReceita");
		String botaoListar = request.getParameter("listarReceitas");
		ArrayList<Conta> contas = null;
		
		if(botaoAdicionar != null ) {			
			contas = new Conta().listarContas();
			request.setAttribute("listaContas", contas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarReceita.jsp");
			dispatcher.forward(request, response);			
		} else if(botaoListar != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);	
		}
	}

}
