# DesafioPubFuture - Wallet Control

Wallet Control é uma aplicação web desenvolvida na linguagem Java com JSP, sem uso de Frameworks, utilizando o modelo de estrutura MVC, e banco de dados relacional MySQL.
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
- IDE Eclipse

- Conector (Driver) do MySQL versão 5.1.47 disponível no diretório **mysql-connector/**.

- Preencher com usuário e senha, o segundo e terceiro parâmetros (USER e PASSWORD) do método na [MySqlConnection](https://github.com/jaconunes/DesafioPubFuture/blob/e4033b668350ab32656380654d4ce360a824e6e6/WalletControl/src/main/java/wallet/dao/MySqlConnection.java#L28 "MySqlConnection")

- Ter o Servidor localhost Apache Tomcat versão 10.0.14 instalado na IDE, que normalmente disponibiliza o acesso à aplicação através da porta 8080.

- Criar base de dados no MySQL com o nome **WALLET**. Os dumps com os scripts para criação das tabelas estão no diretório **Dump20220111/**, que devem ser executados na sequência **"wallet_conta.sql"**, depois **"wallet_receita.sql"** e por fim o **"wallet_despesa.sql"**, evitando possíveis erros com foreign keys. No mesmo diretório, o diagrama relacional das tabelas.

- O projeto final está disponível no diretório **WalletControl/**.


<<<<<<< HEAD

=======
>>>>>>> 1f1da64b0f4d9dbfe46292b47ef61961fbd4e815
Após toda a configuração e servidor "startado", a aplicação poderá ser acessada através da url [localhost:8080/WalletControl/](http://localhost:8080/WalletControl/ "localhost:8080/WalletControl/").

