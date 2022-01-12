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
 * 
 * Classe controladora captura o parâmetro dos botões clicados e realiza as
 * ações de acordo com cada botão.
 * 
 * Servlet implementation class modificarReceitasController
 */
@WebServlet("/modificarReceitasController")
public class modificarReceitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modificarReceitasController() {
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

		String mensagem = null;
		ArrayList<Receita> receitas = new Receita().listarReceitas();

		if (request.getParameter("excluir") != null && request.getParameter("idItemExcluido") != null) {

			if (new Despesa().debitarSaldoConta(Integer.parseInt(request.getParameter("codigoConta")),
					Double.parseDouble(request.getParameter("valorReceita")))) {
				new Receita().excluir(Integer.valueOf(request.getParameter("idItemExcluido")));
				mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita excluída com sucesso!</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("receitas", receitas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
				dispatcher.forward(request, response);
			} else {
				mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">"
						+ "A receita não pode ser excluída! A conta não possui mais saldo suficiente para debitar o valor."
						+ "</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("receitas", receitas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
				dispatcher.forward(request, response);
			}

		} else if (request.getParameter("editar") != null && request.getParameter("idItemExcluido") != null) {
			Receita receita = new Receita().buscarReceitaPorId(Integer.valueOf(request.getParameter("idItemExcluido")));
			request.setAttribute("listaContas", new Conta().listarContas());
			request.setAttribute("receita", receita);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarReceita.jsp");
			dispatcher.forward(request, response);
		}
	}
}
