package com.mycompany.lab2_poo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Lab2_poo {

    public static void main(String[] args) {
        JogoPerguntas jogo = new JogoPerguntas();
        jogo.iniciarJogo();
    }
}

class Pergunta {
    private String texto;
    private String[] alternativas;
    private char respostaCorreta;

    public Pergunta(String texto, String[] alternativas, char respostaCorreta) {
        this.texto = texto;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public void exibirPergunta() {
        System.out.println(texto);
        for (int i = 0; i < alternativas.length; i++) {
            System.out.println((char) ('a' + i) + ") " + alternativas[i]);
        }
    }

    public boolean verificarResposta(char resposta) {
        return resposta == respostaCorreta;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
    }
}

class JogoPerguntas {
    private List<Pergunta> perguntas;
    private int pontuacao;

    public JogoPerguntas() {
        perguntas = new ArrayList<>();
        // Adicione suas perguntas sobre planetas aqui
        perguntas.add(new Pergunta("Qual planeta do Sistema Solar é conhecido por ser o mais próximo do Sol?", new String[]{"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter"}, 'a'));
        perguntas.add(new Pergunta("Qual destes planetas é frequentemente chamado de 'gêmeo da Terra' devido a semelhanças em tamanho e composição?", new String[]{"Vênus", "Júpiter", "Saturno", "Marte", "Urano"}, 'a'));
        perguntas.add(new Pergunta("Qual planeta do Sistema Solar é o único conhecido por abrigar vida até o momento?", new String[]{"Vênus", "Terra", "Marte", "Saturno", "Netuno"}, 'b'));
        perguntas.add(new Pergunta("Este planeta é conhecido por sua coloração avermelhada e é frequentemente chamado de 'Planeta Vermelho'. Qual é?", new String[]{"Terra", "Júpiter", "Marte", "Saturno", "Urano"}, 'c'));
        perguntas.add(new Pergunta("Qual planeta do Sistema Solar é o maior e tem um sistema de anéis visíveis a partir da Terra?", new String[]{"Vênus", "Terra", "Marte", "Saturno", "Netuno"}, 'd'));
        perguntas.add(new Pergunta("Qual destes planetas possui uma inclinação extrema de eixo, fazendo com que ele gire de lado?", new String[]{"Mercúrio", "Terra", "Marte", "Urano", "Netuno"}, 'd'));
        perguntas.add(new Pergunta("Este planeta é famoso por sua coloração azul profunda e seu nome é uma homenagem ao deus romano dos mares. Qual é?", new String[]{"Marte", "Júpiter", "Saturno", "Urano", "Netuno"}, 'e'));
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        pontuacao = 0;

        System.out.println("Bem-vindo ao jogo de perguntas e respostas sobre planetas do Sistema Solar!\n");

        for (Pergunta pergunta : perguntas) {
            pergunta.exibirPergunta();
            System.out.print("Sua resposta: ");
            char resposta = scanner.nextLine().charAt(0);

            if (pergunta.verificarResposta(resposta)) {
                System.out.println("Resposta correta!\n");
                pontuacao++;
            } else {
                System.out.println("Resposta incorreta. A resposta correta era: " + pergunta.getRespostaCorreta() + "\n");
            }
        }

        System.out.println("Pontuação final: " + pontuacao + " de " + perguntas.size() + " perguntas.");
    }
}