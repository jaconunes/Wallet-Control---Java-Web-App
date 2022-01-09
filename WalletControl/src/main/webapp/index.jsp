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
        <section class="inicio text-white text-center p-5">
            <h1>Seja bem-vindo ao Wallet Control!</h1>
            <p>Selecione umas das opções abaixo para gerenciar:</p>
        </section>
        <section>
            <div class="container">
                <div class="row">
                    <div class="botoes text-center text-white col-md-4 col-12">
                        <div class="botao bg-vermelho">
                            <a href="receitas.jsp">
                                <img class="icons" src="img/receitas.png" alt="Receitas">
                                <h2>Receitas</h2>
                            </a>
                        </div>
                    </div>
                    <div class="botoes text-center text-white col-md-4 col-12">
                        <div class="botao bg-vermelho">
                            <a href="despesas.jsp">
                                <img class="icons" src="img/despesas.png" alt="Despesas">
                                <h2>Despesas</h2>
                            </a>
                        </div>
                    </div>
                    <div class="botoes text-center text-white col-md-4 col-12">
                        <div class="botao bg-vermelho">
                            <a href="contas.jsp">
                                <img class="icons" src="img/bank.png" alt="Contas">
                                <h2>Contas</h2>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type='text/javascript' src='js/bootstrap.min.js'></script>
    </body>

    </html>