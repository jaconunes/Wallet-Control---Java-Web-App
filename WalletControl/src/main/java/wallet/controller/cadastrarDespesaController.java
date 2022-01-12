package wallet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Despesa;

/**
 * Classe controladora faz a captura dos parâmetros da tela de cadastro de
 * Despesas, faz a chamada do método para salvar o objeto no banco de dados.
 * 
 * Servlet implementation class cadastrarDespesaController
 */
public class cadastrarDespesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public cadastrarDespesaController() {
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
	 * Método DOPOST faz a captura dos parâmetros da tela de cadastro de Despesas,
	 * faz a chamada do método para salvar o objeto no banco de dados.
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
		String mensagem;
		Boolean retorno = null;
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

		Despesa despesa = new Despesa(Double.parseDouble(request.getParameter("inputValor")), dataPagamento,
				dataPagamentoEsperado, request.getParameter("inputTipoDespesa"),
				Integer.parseInt(request.getParameter("inputConta")));
		retorno = despesa.debitarSaldoConta(Integer.parseInt(request.getParameter("inputConta")),
				Double.parseDouble(request.getParameter("inputValor")));
		if (retorno) {
			despesa.salvar();
			mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Despesa cadastrada com sucesso!</div>";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("despesas.jsp");
			dispatcher.forward(request, response);
		} else {
			mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">"
					+ "A conta selecionada não tem saldo suficiente! Selecione outra conta e tente novamente."
					+ "</div>";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("despesas.jsp");
			dispatcher.forward(request, response);
		}
	}

}
