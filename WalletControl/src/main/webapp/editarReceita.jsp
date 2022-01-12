<%@page import="java.util.List"%>
<%@page import="wallet.model.Conta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="wallet.model.Receita"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css?ver=4.7.0">
<title>Wallet Control</title>
</head>

<body class="bg-azul">
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-vermelho">
			<a class="navbar-brand" href="index.jsp">Wallet Control</a>
			<button class="navbar-toggler text-white" type="button"
				data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Alterna navegação">
				<i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="receitas.jsp">Receitas</a></li>
					<li class="nav-item"><a class="nav-link" href="despesas.jsp">Despesas</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contas.jsp">Contas</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<section class="text-center m-5">
		<h1>Editar Receita</h1>
	</section>
	<section>
		<div class="container">
			<form action="editarReceita" method="post" class="mb-5">
				<%
                	Receita receita = null;
                	if(request.getAttribute("receita") != null){
                		receita = (Receita) request.getAttribute("receita");
                	}
                
                            %>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="inputValor">Valor</label> <input type="number"
							step="0.01" min="0.01" class="form-control" id="inputValor"
							name="inputValor" placeholder="Valor"
							value="<% out.print(receita.getValorReceita()); %>" required>
					</div>
					<div class="form-group col-md-4">
						<label for="inputRecebimento">Data Recebimento</label> <input
							type="date" class="form-control" id="inputRecebimento"
							name="inputRecebimento" placeholder="Recebimento"
							value="<% out.print(receita.getDataRecebimento()); %>" required>
					</div>
					<div class="form-group col-md-4">
						<label for="inputRecebimentoEsperado">Data Recebimento
							Esperado</label> <input type="date" class="form-control"
							id="inputRecebimentoEsperado" name="inputRecebimentoEsperado"
							placeholder="Recebimento Esperado"
							value="<% out.print(receita.getDataRecebimentoEsperado()); %>"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputDescricao">Descrição</label> <input type="text"
						class="form-control" id="inputDescricao" name="inputDescricao"
						placeholder="Descreva sua receita"
						value="<% out.print(receita.getDescricao()); %>" required>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputConta">Conta</label> <select id="inputConta"
							class="form-control" name="inputConta" required>
							<option class="text-dark"
								value="<% out.print(receita.getCodigoConta()); %>" selected>
								<% out.print(receita.getCodigoConta() + " - " + receita.buscarContaPorCodigo(receita.getCodigoConta())); %>
							</option>
							<%                                 
                                if(request.getAttribute("listaContas") != null){
                                    List<?> contas = (List<?>) request.getAttribute("listaContas");
                                    for(int contador = 0; contador <= (contas.size() - 1); contador++){
                                        Conta conta = (Conta) contas.get(contador);                                	
                                %>
							<option class="text-dark"
								value="<% out.print(conta.getIdConta()); %>">
								<% out.print(conta.getIdConta()); %> -
								<% out.print(conta.getInstituicaoFinanceira()); %>
							</option>
							<%}}%>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="inputTipoReceita">Tipo de Receita</label> <select
							id="inputTipoReceita" class="form-control"
							name="inputTipoReceita" required>
							<option class="text-dark" selected>
								<% out.print(receita.getTipoReceita()); %>
							</option>
							<option class="text-dark">Salário</option>
							<option class="text-dark">Presente</option>
							<option class="text-dark">Prêmio</option>
							<option class="text-dark">Outros</option>
						</select>
					</div>
				</div>
				<button type="submit" class="btn btn-success" name="editar">Salvar
					Alteração</button>
				<input type="hidden" name="id"
					value="<% out.print(receita.getIdReceita()); %>"> <input
					type="hidden" name="idContaReceita"
					value="<% out.print(receita.getCodigoConta()); %>">
				<% 
                            String mensagem = (String) request.getAttribute("mensagem");
                            
                            		if(mensagem != null)
                            			out.print(mensagem);
                            		
                        %>
			</form>
		</div>
	</section>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>

</html>