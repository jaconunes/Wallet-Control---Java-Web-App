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
 * Classe controladora faz a busca pela lista de Contas e encaminha para
 * evibição.
 * 
 * Servlet implementation class listarContasController
 */
@WebServlet("/listarContasController")
public class listarContasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listarContasController() {
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
	 * Método DOPOST faz a busca da lista de Contas e encaminha para a exibição na
	 * JSP.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String submitTodas = request.getParameter("listarTodas");
		ArrayList<Conta> contas = null;

		if (submitTodas != null) {
			contas = new Conta().listarContas();
			request.setAttribute("contas", contas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
			dispatcher.forward(request, response);
		}
	}
}
