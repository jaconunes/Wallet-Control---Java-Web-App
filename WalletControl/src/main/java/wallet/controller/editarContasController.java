package wallet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.dao.ContaDao;
import wallet.model.Conta;

/**
 * Classe controladora faz a captura dos parâmetros da tela de edição de Contas,
 * faz a chamada do método para alterar o objeto no banco de dados.
 * 
 * Servlet implementation class editarContasController
 */
@WebServlet("/editarContasController")
public class editarContasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editarContasController() {
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
	 * Método DOPOST faz a captura dos parâmetros da tela de edição de Contas, faz a
	 * chamada do método para alterar o objeto no banco de dados.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int id = Integer.valueOf(request.getParameter("id"));
		double inputValor = Double.parseDouble(request.getParameter("inputValor"));
		String selectTipoConta = request.getParameter("selectTipoConta");
		String inputNomeInstituicao = request.getParameter("inputNomeInstituicao");
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Despesa editada com sucesso!</div>";

		Conta conta = new Conta(id, inputValor, selectTipoConta, inputNomeInstituicao);
		new ContaDao().AlterarConta(conta);

		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
		dispatcher.forward(request, response);

	}
}
