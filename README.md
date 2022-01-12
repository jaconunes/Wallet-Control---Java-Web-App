# DesafioPubFuture - Wallet Control

Wallet Control é uma aplicação web desenvolvida na linguagem Java com JSP, utilizando o modelo de estrutura MVC, e banco de dados relacional MySQL.
Projeto desenvolvido para o Desafio PubFuture da Pública Tecnologia.

## Tecnologias

Este projeto utiliza as seguintes tecnologias:

- Java (Versão 8.0)
- JSP
- HTML
- CSS (Bootstrap)
- MySQL (Banco de Dados)

## Objetivo
Auxiliar o usuário com o controle de finanças pessoais.

## Como executar a aplicação
Conector (Driver) do MySQL versão 5.1.47 disponível no diretório **mysql-connector/**.
Ter o Servidor localhost Apache Tomcat versão 10.0.14 instalado, que normalmente disponibiliza o acesso à aplicação através da porta 8080.

Criar base de dados no MySQL com o nome **WALLET**. Os dumps com os scripts para criação das tabelas estão no diretório **Dump20220111/**, que devem ser executados na sequência **"wallet_conta.sql"**, depois **"wallet_receita.sql"** e por fim o **"wallet_despesa.sql"**, evitando possíveis erros com foreign keys. No mesmo diretório, o diagrama relacional das tabelas.

O projeto final está disponível no diretório **WalletControl/**.

Após toda a configuração e servidor "startado", a aplicação poderá ser acessada através da url [localhost:8080/WalletControl/](http://localhost:8080/WalletControl/ "localhost:8080/WalletControl/").
