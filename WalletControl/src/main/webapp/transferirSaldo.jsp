<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="wallet.model.Conta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
		<h1>Transferir Saldo</h1>
	</section>
	<section>
		<div class="container">
			<form action="transferirSaldo" method="post" class="mb-5">
				<%
				Conta conta = null;
				if (request.getAttribute("conta") != null) {
					conta = (Conta) request.getAttribute("conta");
				}
				%>
				<div class="form-row bb-20">
					<div class="form-group col-md-6">
						<label for="inputSaldo" class="totalsoma vermelho"> <%
 DecimalFormat df = new DecimalFormat("###,###.00");
 out.print("R$ " + df.format(conta.getSaldo()));
 %>
						</label>
					</div>
					<div class="form-group col-md-6">
						<label for="inputInstituicaoFinanceira" class="totalsoma">
							<%
							out.print("Código: " + conta.getIdConta() + " - " + conta.getInstituicaoFinanceira());
							%>
						</label> <input type="hidden" name="IdContaAtual"
							value="<%out.print(conta.getIdConta());%>">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputDescricao">Conta Destino:</label> <select
							id="inputConta" class="form-control" name="selectContaDestino"
							required>
							<option class="text-dark" selected></option>
							<%
							if (request.getAttribute("listaContas") != null) {
								List<?> contas = (List<?>) request.getAttribute("listaContas");
								for (int contador = 0; contador <= (contas.size() - 1); contador++) {
									Conta listaConta = (Conta) contas.get(contador);
							%>
							<option class="text-dark"
								value="<%out.print(listaConta.getIdConta());%>">
								<%
								out.print(listaConta.getIdConta());
								%> -
								<%
								out.print(listaConta.getInstituicaoFinanceira());
								%>
							</option>
							<%
							}
							}
							%>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="inputSaldo">Saldo a Transferir:</label> <input
							type="number" step="0.01" min="0.01" class="form-control"
							id="inputSaldo" name="inputSaldo" placeholder="Saldo" required>
					</div>
				</div>
				<button type="submit" class="btn btn-success" name="editar">Transferir
					Saldo</button>
				<input type="hidden" name="id"
					value="<%out.print(conta.getIdConta());%>">
			</form>
		</div>
		<%
		String mensagem = (String) request.getAttribute("mensagem");
		if (mensagem != null)
			out.print(mensagem);
		%>
	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>

</html>