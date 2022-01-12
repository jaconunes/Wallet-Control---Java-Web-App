package wallet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.dao.ReceitaDao;
import wallet.model.Despesa;
import wallet.model.Receita;

/**
 * Classe controladora faz a captura dos parâmetros da tela de edição de
 * Receitas, faz a chamada do método para alterar o objeto no banco de dados.
 * 
 * Servlet implementation class editarReceitasController
 */
@WebServlet("/editarReceitasController")
public class editarReceitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editarReceitasController() {
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
	 * Método DOPOST faz a captura dos parâmetros da tela de edição de Receitas, faz
	 * a chamada do método para alterar o objeto no banco de dados.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Date dataRecebimento = null;
		Date dataRecebimentoEsperado = null;
		String mensagem = null;
		ArrayList<Receita> receitas = new Receita().listarReceitas();
		try {
			dataRecebimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inputRecebimento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataRecebimentoEsperado = new SimpleDateFormat("yyyy-MM-dd")
					.parse(request.getParameter("inputRecebimentoEsperado"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Receita receita = new Receita(Integer.parseInt(request.getParameter("id")),
				Double.parseDouble(request.getParameter("inputValor")), dataRecebimento, dataRecebimentoEsperado,
				request.getParameter("inputDescricao"), Integer.parseInt(request.getParameter("inputConta")),
				request.getParameter("inputTipoReceita"));

		if (Integer.parseInt(request.getParameter("idContaReceita")) != Integer
				.parseInt(request.getParameter("inputConta"))) {
			Boolean retorno = new Despesa().debitarSaldoConta(Integer.parseInt(request.getParameter("idContaReceita")),
					Double.parseDouble(request.getParameter("inputValor")));
			if (retorno) {
				receita.adicionaSaldoConta(Integer.parseInt(request.getParameter("inputConta")),
						Double.parseDouble(request.getParameter("inputValor")));
				new ReceitaDao().AlterarReceita(receita);
				mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita editada com sucesso!</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("receitas", receitas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
				dispatcher.forward(request, response);
			} else {
				mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">"
						+ "A sua alteração não pode ser executada! A conta atual não tem "
						+ "saldo o suficiente para transferência de valores.</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("receitas", receitas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita editada com sucesso!</div>";
			new ReceitaDao().AlterarReceita(receita);
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("receitas", receitas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);
		}
	}
}
