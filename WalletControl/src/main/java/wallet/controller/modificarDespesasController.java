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
import wallet.model.Receita;

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

		ArrayList<Conta> contas = new Conta().listarContas();
		ArrayList<Despesa> despesas = new Despesa().listarDespesas();
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita excluída com sucesso!</div>";

		if (request.getParameter("excluir") != null && request.getParameter("idItemExcluido") != null) {

			new Despesa().excluir(Integer.valueOf(request.getParameter("idItemExcluido")));
			new Receita().adicionaSaldoConta(Integer.parseInt(request.getParameter("codigoConta")),
					Double.parseDouble(request.getParameter("valorDespesa")));
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("despesas", despesas);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");			
			dispatcher.forward(request, response);
		} else if (request.getParameter("editar") != null && request.getParameter("idItemExcluido") != null) {
			Despesa despesa = new Despesa().buscarDespesaPorId(Integer.valueOf(request.getParameter("idItemExcluido")));
			request.setAttribute("listaContas", contas);
			request.setAttribute("despesa", despesa);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarDespesa.jsp");
			dispatcher.forward(request, response);
		}
	}
}
