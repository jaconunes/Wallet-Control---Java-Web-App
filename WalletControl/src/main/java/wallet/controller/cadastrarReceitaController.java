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
		
		SimpleDateFormat formatoDataRecebimento = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat formatoDataRecebimentoEsperado = new SimpleDateFormat("yyyy-MM-dd");
		double valor;
		String parametroDataRecebimento = request.getParameter("inputRecebimento");
		String parametroDataRecebimentoEsperado = request.getParameter("inputRecebimentoEsperado");
		Date dataRecebimento = null;
		Date dataRecebimentoEsperado = null;
		String descricao = request.getParameter("inputDescricao");
		String codigoConta = request.getParameter("inputConta");
		String tipoReceita = request.getParameter("inputTipoReceita");
		String mensagem;
		try {
			dataRecebimento = formatoDataRecebimento.parse(parametroDataRecebimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			dataRecebimentoEsperado = formatoDataRecebimentoEsperado.parse(parametroDataRecebimentoEsperado);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		if(request.getParameter("inputValor") != null && dataRecebimento != null 
				&& dataRecebimentoEsperado != null && descricao != null && codigoConta != null && tipoReceita != null) {
			
			valor = Double.parseDouble(request.getParameter("inputValor"));
			int codConta = Integer.parseInt(codigoConta);
			
			Receita receita = new Receita(valor, dataRecebimento, dataRecebimentoEsperado, descricao, codConta, tipoReceita);
			receita.salvar();
			receita.adicionaSaldoConta(codConta, valor);
			
			mensagem = "<div class=\"alert alert-success mt-3\" role=\"alert\">Receita cadastrada com sucesso!</div>";			
			RequestDispatcher dispatcher = request.getRequestDispatcher("receitas.jsp");
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
			
		} else {
			
			mensagem = "<div class=\"alert alert-warning mt-3\" role=\"alert\">\r\n"
					+ "Preencha todas as informações!\r\n"
					+ "</div>";	
						
		}
		
		
		
		
		
		
	}

}
