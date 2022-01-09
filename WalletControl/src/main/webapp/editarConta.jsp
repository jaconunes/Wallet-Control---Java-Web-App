<%@page import="wallet.model.Conta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/Style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css?ver=4.7.0">
        <title>Wallet Control</title>
    </head>

    <body class="bg-azul">
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-vermelho">
                <a class="navbar-brand" href="index.jsp">Wallet Control</a>
                <button class="navbar-toggler text-white" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Alterna navegação">
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="receitas.jsp">Receitas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="despesas.jsp">Despesas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contas.jsp">Contas</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="text-center m-5">
            <h1>Editar Conta</h1>
        </section>
        <section>
            <div class="container">
                <form action="editarConta" method="post" class="mb-5">
                    <% 
                        Conta conta = null;
                        if(request.getAttribute("conta") != null){
                            conta = (Conta) request.getAttribute("conta");
                        } 
                    %>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="inputValor">Saldo</label>
                                <input type="number" class="form-control" id="inputValor" placeholder="Valor" name="inputValor" value="<% out.print(conta.getSaldo()); %>" required>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="selectTipoConta">Tipo de Conta</label>
                                <select id="selectTipoConta" class="form-control" name="selectTipoConta" required>
                                <option class="text-dark" selected><% out.print(conta.getTipoConta()); %></option>
                                <option class="text-dark" >Carteira</option>
                                <option class="text-dark" >Conta Corrente</option>
                                <option class="text-dark" >Conta Poupança</option>
                            </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputNomeInstituicao">Instituição Financeira</label>
                                <input type="text" class="form-control" id="inputNomeInstituicao" placeholder="Nome da Instituição Financeira" name="inputNomeInstituicao" value="<% out.print(conta.getInstituicaoFinanceira()); %>" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success">Salvar Alteração</button>
                        <input type="hidden" name="id" value="<% out.print(conta.getIdConta()); %>">
                                        <% 
                            String mensagem = (String) request.getAttribute("mensagem");
                            
                            		if(mensagem != null)
                            			out.print(mensagem);
                            		
                        %>
                </form>
            </div>

        </section>
        <script type='text/javascript' src='js/bootstrap.min.js'></script>
    </body>

    </html>