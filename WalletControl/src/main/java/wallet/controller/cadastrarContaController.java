package wallet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Conta;

/**
 * Classe controladora da página de cadastro de Contas, captura os parâmetros e
 * chama o método para salvar o objeto Conta.
 * 
 * Servlet implementation class cadastrarContaController
 */
public class cadastrarContaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public cadastrarContaController() {
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
	 * Método DOPOST faz a captura dos parâmetros da tela de cadastro de Contas, faz
	 * a chamada do método para salvar o objeto no banco de dados.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Conta cadastrada com sucesso!</div>";

		Conta conta = new Conta(Double.parseDouble(request.getParameter("inputValor")),
				request.getParameter("selectTipoConta"), request.getParameter("inputNomeInstituicao"));
		conta.salvar();

		RequestDispatcher dispatcher = request.getRequestDispatcher("contas.jsp");
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);

	}
}
