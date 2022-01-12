package wallet.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Despesa;

/**
 * Classe controladora faz a busca pela lista de Despesas e encaminha para
 * evibição.
 * 
 * Servlet implementation class listarDespesasController
 */
@WebServlet("/listarDespesasController")
public class listarDespesasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listarDespesasController() {
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
	 * Método DOPOST faz a busca da lista de Despesas e encaminha para a exibição na
	 * JSP.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ArrayList<Despesa> despesas = null;

		if (request.getParameter("listarTodas") != null) {
			despesas = new Despesa().listarDespesas();
			request.setAttribute("despesas", despesas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("filtroPorTipo") != null) {
			despesas = new Despesa().buscarDespesasPorTipo(request.getParameter("inputTipoDespesa"));
			request.setAttribute("despesas", despesas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("filtroPorPeriodo") != null) {
			despesas = new Despesa().buscarDespesasPorPeriodo(request.getParameter("dataInicio"),
					request.getParameter("dataFim"));
			request.setAttribute("despesas", despesas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			dispatcher.forward(request, response);

		}
	}
}
