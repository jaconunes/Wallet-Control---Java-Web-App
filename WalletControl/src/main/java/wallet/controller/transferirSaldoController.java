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
 * Classe controladora chama o método resposável por transferir saldo de uma Conta
 * para outra.
 * 
 * Servlet implementation class transferirSaldoController
 */
@WebServlet("/transferirSaldoController")
public class transferirSaldoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public transferirSaldoController() {
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
	 * Método DOPOST captura os parâmetros da tela de transferência de saldo, chama
	 * o método responsável e realização a alteração.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Saldo transferido com sucesso!</div>";
		ArrayList<Conta> contas = new Conta().listarContas();

		new Conta().transferirSaldo(Integer.valueOf(request.getParameter("IdContaAtual")),
				Integer.valueOf(request.getParameter("selectContaDestino")),
				Double.parseDouble(request.getParameter("inputSaldo")));

		request.setAttribute("mensagem", mensagem);
		request.setAttribute("contas", contas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
		dispatcher.forward(request, response);

	}
}
