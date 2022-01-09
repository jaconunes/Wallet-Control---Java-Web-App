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
 * Servlet implementation class modificarContasController
 */
@WebServlet("/modificarContasController")
public class modificarContasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet() 
     */
    public modificarContasController() {
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
		
		String excluir = request.getParameter("excluir");
		String editar = request.getParameter("editar");
		String transferir = request.getParameter("transferir");		
		String id = request.getParameter("idItemExcluido");
		ArrayList<Conta> contas = null;
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Conta excluída com sucesso!</div>";
		
			if(excluir != null && id != null) {
				new Conta().excluir(Integer.valueOf(id));
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarContas.jsp");
				dispatcher.forward(request, response);
				System.out.println("Botão Excluir");
			} else if(editar != null && id != null) {
				Conta conta = new Conta().buscarContaPorId(Integer.valueOf(id));
				request.setAttribute("conta", conta);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editarConta.jsp");
				dispatcher.forward(request, response);
				System.out.println("Botão editar");
			} else if(transferir != null && id != null) {
				Conta conta = new Conta().buscarContaPorId(Integer.valueOf(id));
				contas = new Conta().listarContas();
				request.setAttribute("listaContas", contas);
				request.setAttribute("conta", conta);
				RequestDispatcher dispatcher = request.getRequestDispatcher("transferirSaldo.jsp");
				dispatcher.forward(request, response);
				System.out.println("Botão transferir");
			}
		}
	}


