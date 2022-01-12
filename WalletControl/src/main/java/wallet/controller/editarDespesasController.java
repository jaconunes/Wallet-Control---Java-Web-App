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
import wallet.dao.DespesaDao;
import wallet.model.Despesa;
import wallet.model.Receita;

/**
 * Classe controladora faz a captura dos parâmetros da tela de edição de
 * Despesas, faz a chamada do método para alterar o objeto no banco de dados.
 * 
 * Servlet implementation class editarDespesasController
 */
@WebServlet("/editarDespesasController")
public class editarDespesasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editarDespesasController() {
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
	 * Método DOPOST faz a captura dos parâmetros da tela de edição de Despesas, faz
	 * a chamada do método para alterar o objeto no banco de dados.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Date dataPagamento = null;
		Date dataPagamentoEsperado = null;
		String mensagem = null;
		ArrayList<Despesa> despesas = new Despesa().listarDespesas();
		try {
			dataPagamento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inputPagamento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataPagamentoEsperado = new SimpleDateFormat("yyyy-MM-dd")
					.parse(request.getParameter("inputPagamentoEsperado"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Despesa despesa = new Despesa(Integer.parseInt(request.getParameter("id")),
				Double.parseDouble(request.getParameter("inputValor")), dataPagamento, dataPagamentoEsperado,
				request.getParameter("inputTipoDespesa"), Integer.parseInt(request.getParameter("inputConta")));

		if (Integer.parseInt(request.getParameter("idContaDespesaEditada")) != Integer
				.parseInt(request.getParameter("inputConta"))) {
			Boolean retorno = despesa.debitarSaldoConta(Integer.parseInt(request.getParameter("inputConta")),
					Double.parseDouble(request.getParameter("inputValor")));
			if (retorno) {
				new DespesaDao().AlterarDespesa(despesa);
				new Receita().adicionaSaldoConta(Integer.parseInt(request.getParameter("idContaDespesaEditada")),
						Double.parseDouble(request.getParameter("inputValor")));
				mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Despesa editada com sucesso!</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("despesas", despesas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
				dispatcher.forward(request, response);
			} else {
				mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">"
						+ "A sua alteração não pode ser executada! A conta selecionada não tem "
						+ "saldo o suficiente para o débito do valor.</div>";
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("despesas", despesas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Despesa editada com sucesso!</div>";
			new DespesaDao().AlterarDespesa(despesa);
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("despesas", despesas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			dispatcher.forward(request, response);
		}

	}
}
