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
import wallet.model.Receita;

/**
 * Servlet implementation class modificarReceitasController
 */
@WebServlet("/modificarReceitasController")
public class modificarReceitasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet() 
     */
    public modificarReceitasController() {
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
		String id = request.getParameter("idItemExcluido");
		ArrayList<Conta> contas = null;
		String mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita excluída com sucesso!</div>";
		
			if(excluir != null && id != null) {
				new Receita().excluir(Integer.valueOf(id));
				RequestDispatcher dispatcher = request.getRequestDispatcher("listarReceitas.jsp");
				request.setAttribute("mensagem", mensagem);
				dispatcher.forward(request, response);
			} else if(editar != null && id != null) {
				Receita receita = new Receita().buscarReceitaPorId(Integer.valueOf(id));
				contas = new Conta().listarContas();
				request.setAttribute("listaContas", contas);
				request.setAttribute("receita", receita);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editarReceita.jsp");
				dispatcher.forward(request, response);
			}
		}
	}


