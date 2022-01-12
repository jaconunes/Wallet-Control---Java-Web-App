package wallet.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Receita;

/**
 * Classe controladora faz a busca pela lista de Receitas e encaminha para
 * evibição.
 * 
 * Servlet implementation class listarReceitasController
 */
@WebServlet("/listarReceitasController")
public class listarReceitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listarReceitasController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	/**
	 * Método DOPOST faz a busca da lista de Receitas e encaminha para a exibição na
	 * JSP.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ArrayList<Receita> receitas = null;

		if (request.getParameter("listarTodas") != null) {
			receitas = new Receita().listarReceitas();
			request.setAttribute("receitas", receitas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("filtroPorTipo") != null) {
			receitas = new Receita().buscarReceitaPorTipo(request.getParameter("inputTipoReceita"));
			request.setAttribute("receitas", receitas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("filtroPorPeriodo") != null) {
			receitas = new Receita().buscarReceitaPorPeriodo(request.getParameter("dataInicio"),
					request.getParameter("dataFim"));
			request.setAttribute("receitas", receitas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);

		}
	}
}
