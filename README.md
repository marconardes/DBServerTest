# DBServer teste
[![Build Status](https://travis-ci.org/marconardes/DBServerTest.svg?branch=master)](https://travis-ci.org/marconardes/DBServerTest)

Requisitos do sistema
===================

1. JDK 8+ 
2. Apache Maven ou Eclipse com o projeto mavem, as dependencias de pacotes estão no maven.
3. Mysql;

Instalação
==================================================================================
Altere o percistence.xml no lugar do meuUsuario, vai o usuario do banco de dados, no lugar da minhaSenha, vai a senha.
  <property name="javax.persistence.jdbc.user" value="meuUsuario"/>
  <property name="javax.persistence.jdbc.password" value="minhaSenha"/>
  
Execute o commando mvn clean test para executar os testes unitarios.
Execute o commando mvn deploy criar os arquivos jar.
Execute o comando java -cp vottingRestaurants-jar-with-dependencies.jar com.marco.install.Install para instalar os as tabelas para teste.
Para executar o programa use java -jar vottingRestaurants-jar-with-dependencies.jar;


Execução
=============================
Foi criado apenas 3 usuario que são selecionadoe em uma lista.

| Usuario          | Senha         | 
| -------------  |:-------------:|
| Usuario1         | 1             |
| Usuario2         | 2             |
| Usuario3         | 3             |

O horario valido para escolher os restaurantes é das 8:00 as 11:30, mas não se preocupe, foi colocado uns botões que alteram a hora de teste,

| Botão          | Efeito         | 
| -------------  |:-------------:|
| Hora Valida       | Coloca o sistema em uma hora valida             |
| Finaliza a votação       | Coloca o dia no final do periodo             |


Destaques
==========
A classe VottingSystem, está bem implementada, e retornando corretamente os dados, embora precise melhorar um pouco.

O que melhorar
================
A interface grafica está muito ruim, vou migrar para a web essa semana.
Criar um cadastro de usuarios e restaurantes, ainda não tem.
Melhorar a cobertura dos testes.
