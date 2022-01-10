package wallet.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Receita;

/**
 * Servlet implementation class listarReceitasController
 */
@WebServlet("/listarReceitasController")
public class listarReceitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet() 
     */
    public listarReceitasController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String submitTodas = request.getParameter("listarTodas");
		String submitPorTipo = request.getParameter("filtroPorTipo");
		String tipoSelecionado = request.getParameter("inputTipoReceita");
		String submitPorPeriodo = request.getParameter("filtroPorPeriodo");
		String dataInicial = request.getParameter("dataInicio");
		String dataFinal = request.getParameter("dataFim");
		ArrayList<Receita> receitas = null;
		
				if(submitTodas != null) {
					receitas = new Receita().listarReceitas();
					request.setAttribute("receitas", receitas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
					dispatcher.forward(request, response);
				} else if(submitPorTipo != null) {
					receitas = new Receita().buscarReceitaPorTipo(tipoSelecionado);
					request.setAttribute("receitas", receitas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
					dispatcher.forward(request, response);
				} else if(submitPorPeriodo != null) {
					receitas = new Receita().buscarReceitaPorPeriodo(dataInicial, dataFinal);
					request.setAttribute("receitas", receitas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
					dispatcher.forward(request, response);
					
					
				}
			}
	}


