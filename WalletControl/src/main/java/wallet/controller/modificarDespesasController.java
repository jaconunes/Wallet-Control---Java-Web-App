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
import wallet.model.Despesa;

/**
 * Classe controladora captura o parâmetro dos botões clicados e realiza as
 * ações de acordo com cada botão.
 * 
 * Servlet implementation class modificarDespesasController
 */
@WebServlet("/modificarDespesasController")
public class modificarDespesasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modificarDespesasController() {
		super();
	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	/**
	 * Método DOPOST captura a ação na JSP de acordo com cada botão clicado realiza
	 * uma ação, editar ou excluir.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String excluir = request.getParameter("excluir");
		String editar = request.getParameter("editar");
		String id = request.getParameter("idItemExcluido");
		ArrayList<Conta> contas = null;
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita excluída com sucesso!</div>";

		if (excluir != null && id != null) {
			new Despesa().excluir(Integer.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			request.setAttribute("mensagem", mensagem);
			dispatcher.forward(request, response);
		} else if (editar != null && id != null) {
			Despesa despesa = new Despesa().buscarDespesaPorId(Integer.valueOf(id));
			contas = new Conta().listarContas();
			request.setAttribute("listaContas", contas);
			request.setAttribute("despesa", despesa);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarDespesa.jsp");
			dispatcher.forward(request, response);
		}
	}
}
