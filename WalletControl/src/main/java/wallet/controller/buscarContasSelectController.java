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
 * Classe controladora que retorna uma lista de contas e envia para as páginas
 * de cadastro de Receitas e Despesas ou simplesmente redireciona paras as
 * páginas de listagens.
 * 
 * Servlet implementation class bucarContasSelectController
 */
@WebServlet("/buscarContasSelectController")
public class buscarContasSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public buscarContasSelectController() {
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
	 * Método DOPOST faz a captura de parâmetros das páginas iniciais de Receita ou
	 * Despesa, faz as devidas consultas de contas e redireciona para as páginas de
	 * cadastro ou listagem.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ArrayList<Conta> contas = new Conta().listarContas();
		
		if (request.getParameter("adicionarReceita") != null) {
			request.setAttribute("listaContas", contas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarReceita.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("adicionarDespesa") != null) {
			request.setAttribute("listaContas", contas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarDespesa.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("adicionarConta") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarConta.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("listarReceitas") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("listarDespesas") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("listarContas") != null) {
			request.setAttribute("contas", contas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
			dispatcher.forward(request, response);
		}
	}

}
