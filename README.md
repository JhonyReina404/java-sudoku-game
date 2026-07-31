# Sudoku Java

## 📖 Sobre o Projeto

Este projeto consiste na implementação de um jogo de **Sudoku** desenvolvido em **Java**, como parte das atividades do **Bootcamp DIO & Globant - Java & Spring Boot AI Developer**.

O projeto foi criado com o objetivo de praticar conceitos fundamentais da linguagem Java e da Programação Orientada a Objetos, evoluindo de uma versão em console para uma interface gráfica utilizando **Java Swing**.

---

## 📷 Interface

![Tela principal](assets/telaPrincipal.pgn)

---

## ✨ Funcionalidades

* Interface gráfica desenvolvida com Java Swing;
* Carregamento de puzzles a partir de um arquivo `puzzles.txt`;
* Seleção aleatória de partidas;
* Validação das jogadas e atualização do tabuleiro;
* Reinício da partida mantendo o mesmo puzzle.

---

## 🎮 Jogabilidade

* O jogador pode preencher livremente as células editáveis utilizando valores de **1 a 9**;
* As jogadas não possuem limite de tentativas ou tempo;
* A verificação da solução é realizada apenas quando o jogador solicitar a conclusão da partida;
* O jogo não fornece dicas, correções automáticas ou destaque de erros durante a resolução.

---

## 📁 Estrutura dos Puzzles

Os desafios são armazenados no arquivo `resources/puzzles.txt`, onde cada jogo é composto pelo tabuleiro inicial (`#Puzzle`) e sua respectiva solução (`#Solution`).

Durante a inicialização, todos os puzzles são carregados em memória, um deles é escolhido aleatoriamente e utilizado para criar o tabuleiro da partida.

---

## 🛠️ Tecnologias Utilizadas

* Java
* Java Swing
* Java Collections
* Java NIO (`Files` e `Path`)

---

## 📚 Objetivos de Aprendizagem

Este projeto foi desenvolvido com foco no aprendizado, colocando em prática conceitos como:

* Programação Orientada a Objetos (POO);
* Separação de responsabilidades;
* Manipulação de arquivos;
* Tratamento de eventos no Java Swing;
* Organização da lógica de negócio e da interface gráfica.
