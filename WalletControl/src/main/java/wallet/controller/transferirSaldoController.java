package wallet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wallet.model.Conta;

/**
 * Servlet implementation class transferirSaldoController
 */
@WebServlet("/transferirSaldoController")
public class transferirSaldoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet() 
     */
    public transferirSaldoController() {
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
		
		int idIdContaAtual = Integer.valueOf(request.getParameter("IdContaAtual"));	
		int idIdContaDestino = Integer.valueOf(request.getParameter("selectContaDestino"));
		double saldoATransferir = Double.parseDouble(request.getParameter("inputSaldo"));
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Saldo transferido com sucesso!</div>";
		
		new Conta().transferirSaldo(idIdContaAtual, idIdContaDestino, saldoATransferir);
		
		request.setAttribute("mensagem", mensagem);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
		dispatcher.forward(request, response);
		
		}
	}


