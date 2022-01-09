package wallet.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Despesa;

/**
 * Servlet implementation class listarDespesasController
 */
@WebServlet("/listarDespesasController")
public class listarDespesasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet() 
     */
    public listarDespesasController() {
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
		String tipoSelecionado = request.getParameter("inputTipoDespesa");
		String submitPorPeriodo = request.getParameter("filtroPorPeriodo");
		String dataInicial = request.getParameter("dataInicio");
		String dataFinal = request.getParameter("dataFim");
		ArrayList<Despesa> despesas = null;
		
				if(submitTodas != null) {
					despesas = new Despesa().listarDespesas();
					request.setAttribute("despesas", despesas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
					dispatcher.forward(request, response);
				} else if(submitPorTipo != null) {
					despesas = new Despesa().buscarDespesasPorTipo(tipoSelecionado);
					request.setAttribute("despesas", despesas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
					dispatcher.forward(request, response);
				} else if(submitPorPeriodo != null) {
					despesas = new Despesa().buscarDespesasPorPeriodo(dataInicial, dataFinal);					
					request.setAttribute("despesas", despesas);
					RequestDispatcher dispatcher = request.getRequestDispatcher("listarDespesas.jsp");
					dispatcher.forward(request, response);
					
					
				}
			}
	}


