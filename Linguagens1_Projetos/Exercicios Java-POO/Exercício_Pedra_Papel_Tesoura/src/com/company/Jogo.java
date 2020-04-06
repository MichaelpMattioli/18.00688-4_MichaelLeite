package com.company;
import java.util.Scanner;
public class Jogo {
    private Jogador j1, j2;
    public void jogar(){

        System.out.println("Informe o nome do Jogador 1:");
        String nome = scanner.nextLine();

        menuOpcao();

        System.out.println("Informe o nome do Jogador 2:");
        String nome = scanner.nextLine();
        System.out.println("Jogada do Jogador 2:");
        menuOpcao();
        int escolha = Integer.parseInt(scanner.nextLine());

        switch (escolha){
            case 1:
                j1 = new Jogador(nome, Jogada.PEDRA); break;
            case 2:
                j1 = new Jogador(nome, Jogada.TESOURA); break;
            default:
                j1 = new Jogador(nome, Jogada.PAPEL); break;
        }
    }

    private Jogador menuOpcao(Jogador jogador){

        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("Jogada do Jogador " + nome ": ");
        System.out.println("1 - Pedra.");
        System.out.println("2 - Tesoura.");
        System.out.println("3 - Papel.");
    }
}