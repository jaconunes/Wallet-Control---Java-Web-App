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
 * Classe controladora captura o parâmetro dos botões clicados e realiza as
 * ações de acordo com cada botão.
 * 
 * Servlet implementation class modificarContasController
 */
@WebServlet("/modificarContasController")
public class modificarContasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modificarContasController() {
		super();
	}

	/**
	 * Método DOPOST captura a ação na JSP de acordo com cada botão clicado realiza
	 * uma ação, transferir, editar ou excluir.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mensagem = null;

		if (request.getParameter("excluir") != null && request.getParameter("idItemExcluido") != null) {
			mensagem = new Conta().excluir(Integer.valueOf(request.getParameter("idItemExcluido")));
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("editar") != null && request.getParameter("idItemExcluido") != null) {
			Conta conta = new Conta().buscarContaPorId(Integer.valueOf(request.getParameter("idItemExcluido")));
			request.setAttribute("conta", conta);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarConta.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("transferir") != null && request.getParameter("idItemExcluido") != null) {
			Conta conta = new Conta().buscarContaPorId(Integer.valueOf(request.getParameter("idItemExcluido")));
			ArrayList<Conta> contas = new Conta().listarContas();
			request.setAttribute("listaContas", contas);
			request.setAttribute("conta", conta);
			RequestDispatcher dispatcher = request.getRequestDispatcher("transferirSaldo.jsp");
			dispatcher.forward(request, response);
		}
	}
}
