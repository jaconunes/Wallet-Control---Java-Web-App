<%@page import="wallet.model.Despesa"%>
<%@page import="java.util.List"%>
    <%@page import="wallet.model.Conta"%>
        <%@page import="java.text.SimpleDateFormat"%>
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                                        <a class="nav-link" href="despesas.jsp">Despesas</a>
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
                        <h1>Editar Despesa</h1>
                    </section>
                    <section>
                        <div class="container">
                            <form action="editarDespesa" method="post" class="mb-5">
                                <%
				                	Despesa despesa = null;
				                	if(request.getAttribute("despesa") != null){
				                		despesa = (Despesa) request.getAttribute("despesa");
				                	}                
                				%>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="inputValor">Valor</label>
                                            <input type="number" step="0.01" min="0.01" class="form-control" id="inputValor" name="inputValor" placeholder="Valor" value="<% out.print(despesa.getValor()); %>" required>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="inputPagamento">Data Pagamento</label>
                                            <input type="date" class="form-control" id="inputPagamento" name="inputPagamento" placeholder="Pagamento" value="<% out.print(despesa.getDataPagamento()); %>" required>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="inputPagamentoEsperado">Data Pagamento Esperado</label>
                                            <input type="date" class="form-control" id="inputPagamentoEsperado" name="inputPagamentoEsperado" placeholder="Pagamento Esperado" value="<% out.print(despesa.getDataPagamentoEsperado()); %>" required>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputTipoDespesa">Tipo de Despesa</label>
                                            <select id="inputTipoDespesa" class="form-control" name="inputTipoDespesa" required>
                                <option class="text-dark"  selected><% out.print(despesa.getTipoDespesa()); %></option>
                                			<option class="text-dark" >Alimentação</option>
                                            <option class="text-dark" >Educação</option>
                                            <option class="text-dark" >Lazer</option>
                                            <option class="text-dark" >Moradia</option>
                                            <option class="text-dark" >Roupa</option>
                                            <option class="text-dark" >Saúde</option>
                                            <option class="text-dark" >Transporte</option>
                                            <option class="text-dark" >Outros</option>
                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="inputConta">Conta</label>
                                            <select id="inputConta" class="form-control" name="inputConta" required>
                                <option class="text-dark" value="<% out.print(despesa.getCodigoConta()); %>" selected><% out.print(despesa.getCodigoConta() + " - " + despesa.buscarContaPorCodigo(despesa.getCodigoConta())); %></option>
                                <%                                 
                                if(request.getAttribute("listaContas") != null){
                                    List<?> contas = (List<?>) request.getAttribute("listaContas");
                                    for(int contador = 0; contador <= (contas.size() - 1); contador++){
                                        Conta conta = (Conta) contas.get(contador);                                	
                                %>                                
                                <option class="text-dark" value="<% out.print(conta.getIdConta()); %>"><% out.print(conta.getIdConta()); %> - <% out.print(conta.getInstituicaoFinanceira()); %></option>                                
                                <%}}%>                                
                            </select>
                                        </div>

                                    </div>
                                    <button type="submit" class="btn btn-success" name="editar">Salvar Alteração</button>
                                    <input type="hidden" name="id" value="<% out.print(despesa.getIdDespesa()); %>">
                                    <input type="hidden" name="idContaDespesaEditada" value="<% out.print(despesa.getCodigoConta()); %>">
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