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

		SimpleDateFormat formatoDataPagamento = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoDataPagamentoEsperado = new SimpleDateFormat("yyyy-MM-dd");
		double valor;
		String parametroDataPagamento = request.getParameter("inputPagamento");
		String parametroDataPagamentoEsperado = request.getParameter("inputPagamentoEsperado");
		Date dataPagamento = null;
		Date dataPagamentoEsperado = null;
		String conta = request.getParameter("inputConta");
		String tipoDespesa = request.getParameter("inputTipoDespesa");
		String mensagem;
		try {
			dataPagamento = formatoDataPagamento.parse(parametroDataPagamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataPagamentoEsperado = formatoDataPagamentoEsperado.parse(parametroDataPagamentoEsperado);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (request.getParameter("inputValor") != null && dataPagamento != null && dataPagamentoEsperado != null
				&& conta != null && tipoDespesa != null) {

			valor = Double.parseDouble(request.getParameter("inputValor"));
			int codigoConta = Integer.parseInt(conta);

			Despesa despesa = new Despesa(valor, dataPagamento, dataPagamentoEsperado, tipoDespesa, codigoConta);
			despesa.salvar();
			despesa.debitarSaldoConta(codigoConta, valor);
			mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Despesa cadastrada com sucesso!</div>";

			RequestDispatcher dispatcher = request.getRequestDispatcher("despesas.jsp");
			request.setAttribute("mensagem", mensagem);
			dispatcher.forward(request, response);

		} else {

			mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">\r\n"
					+ "Preencha todas as informações!\r\n" + "</div>";

		}

	}

}
