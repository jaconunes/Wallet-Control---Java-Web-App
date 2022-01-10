package wallet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.dao.ReceitaDao;
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

		SimpleDateFormat formatoDataRecebimento = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoDataRecebimentoEsperado = new SimpleDateFormat("yyyy-MM-dd");

		int id = Integer.valueOf(request.getParameter("id"));
		double valor = Double.parseDouble(request.getParameter("inputValor"));
		String paramentoDataRecebimento = request.getParameter("inputRecebimento");
		String paramentoDataRecebimentoEsperado = request.getParameter("inputRecebimentoEsperado");
		Date dataRecebimento = null;
		Date dataRecebimentoEsperado = null;
		String descricao = request.getParameter("inputDescricao");
		int codigoConta = Integer.parseInt(request.getParameter("inputConta"));
		String tipoReceita = request.getParameter("inputTipoReceita");
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita editada com sucesso!</div>";
		try {
			dataRecebimento = formatoDataRecebimento.parse(paramentoDataRecebimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataRecebimentoEsperado = formatoDataRecebimentoEsperado.parse(paramentoDataRecebimentoEsperado);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Receita receita = new Receita(id, valor, dataRecebimento, dataRecebimentoEsperado, descricao, codigoConta,
				tipoReceita);
		new ReceitaDao().AlterarReceita(receita);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
	}
}
