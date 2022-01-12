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
import wallet.model.Receita;

/**
 * Classe controladora faz a captura dos parâmetros da tela de cadastro de
 * Receitas, faz a chamada do método para salvar o objeto no banco de dados.
 * 
 * Servlet implementation class cadastrarReceitaController
 */
public class cadastrarReceitaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public cadastrarReceitaController() {

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
	 * Método DOPOST faz a captura dos parâmetros da tela de cadastro de Receitas,
	 * faz a chamada do método para salvar o objeto no banco de dados.
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
		String mensagem;

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

		Receita receita = new Receita(Double.parseDouble(request.getParameter("inputValor")), dataRecebimento,
				dataRecebimentoEsperado, request.getParameter("inputDescricao"),
				Integer.parseInt(request.getParameter("inputConta")), request.getParameter("inputTipoReceita"));
		receita.salvar();
		receita.adicionaSaldoConta(Integer.parseInt(request.getParameter("inputConta")),
				Double.parseDouble(request.getParameter("inputValor")));

		mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita cadastrada com sucesso!</div>";
		RequestDispatcher dispatcher = request.getRequestDispatcher("receitas.jsp");
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);

	}

}
