<%@page import="wallet.model.Conta"%>
<%@page import="java.text.DecimalFormat"%>
    <%@page import="java.text.SimpleDateFormat"%>
        <%@page import="java.util.List"%>
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
                        <h1>Contas</h1>
                    </section>
                    <section>
                        <div class="container-fluid">
                            <form action="listarContas" method="post">
                                <div class="form-row mb-3">
                                    <div class="form-group col-md-3">
                                        <button class="btn border border-white text-white" id="listarTodas" type="submit" name="listarTodas">Listar Todas</button>
                                    </div>
                                </div>
                            </form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Saldo</th>
                                        <th scope="col">Tipo Conta</th>
                                        <th scope="col">Instituição Financeira</th>
                                        <th scope="col"><i class=" fa fa-share-square-o " aria-hidden="true "></i></th>
                                        <th scope="col"><i class="fa fa-pencil-square-o " aria-hidden="true "></i></th>
                                        <th scope="col"><i class="fa fa-trash-o " aria-hidden="true "></i></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% 
                                    String mensagem = (String) request.getAttribute("mensagem");
                            
                            		if(mensagem != null){
                            			out.print(mensagem);
                            		}
                            			
                            		Double totalSoma = 0.0;
                                
                                    if(request.getAttribute("contas") != null){
                                        List<?> contas = (List<?>) request.getAttribute("contas");
                                        for(int contador = 0; contador <= (contas.size() - 1); contador++){
                                            Conta conta = (Conta) contas.get(contador);
                                            totalSoma += conta.getSaldo();
                                		%>
                                        <form action="modificarContas" method="post">
                                            <tr>
                                                <th scope="row">
                                                    <% out.print(conta.getIdConta()); %>
                                                        <input type="hidden" name="idItemExcluido" value="<% out.print(conta.getIdConta()); %>">
                                        </th>
                                        <td>
                                            <% 
                                                        DecimalFormat df = new DecimalFormat("###,###.00");
                                                        out.print("R$ "+ df.format(conta.getSaldo())); 
                                                        %>
                                        </td>
                                        <td>
                                            <% out.print(conta.getTipoConta()); %>
                                        </td>
                                        <td>
                                            <% out.print(conta.getInstituicaoFinanceira()); %>
                                        </td>
                                        <td>
                                            <input type="submit" class="btn text-white font-italic font-weight-bold" name="transferir" value="Transferir">
                                        </td>
                                        <td>
                                            <input type="submit" class="btn text-white font-italic font-weight-bold" name="editar" value="Editar">
                                        </td>
                                        <td>
                                            <input type="submit" class="btn text-white font-italic font-weight-bold" name="excluir" value="Excluir">
                                        </td>
                                    </tr>
                                    </form>
                                    <% }} %>
                                        </tbody>
                            </table>
                            <div class="form-row">
                                <div class="form-group col-md-12 text-left">
                                    <p class="totalsoma vermelho">
                                        Saldo total:
                                        <% 
                            		DecimalFormat dfTotal = new DecimalFormat("###,###.00"); 
                            		out.print("R$ " + dfTotal.format(totalSoma)); %>
                                    </p>
                                </div>

                            </div>
                            </form>
                        </div>
                    </section>
                    <script type='text/javascript' src='js/bootstrap.min.js'></script>
                </body>

                </html>