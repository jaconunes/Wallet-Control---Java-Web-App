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
	<section class="mt-5">
		<div class="container">
			<%
			String mensagem = (String) request.getAttribute("mensagem");

			if (mensagem != null)
				out.print(mensagem);
			%>
			<form action="adicionar-listar" method="post">
				<div class="form-row">
					<div class="col">
						<button type="submit" class="botao-receita"
							name="adicionarDespesa">
							<img class="icons" src="images/despesas.png" alt="Adicionar Receita">
							<h2>Adicionar Despesa</h2>
						</button>
					</div>
					<div class="col">
						<button type="submit" class="botao-receita" name="listarDespesas">
							<img class="icons" src="images/lista-receitas.png"
								alt="Listar Receitas">
							<h2>Listar Despesas</h2>
						</button>
					</div>
				</div>
			</form>
		</div>
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