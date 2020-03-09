package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite seu nome : ");
            String nome1 = ler.nextLine();

        System.out.println("Agora a sua idade : ");
            int idade1 = Integer.parseInt(ler.nextLine());
            // Duvida por que motivo tem que mudar a string para int para que não pule o próximo scanner
            // Caso faça o codigo em : int idade1 = ler.netInt(); pulará o String nome2 = ler.netLine();

        System.out.println("Digite seu nome : ");
            String nome2 = ler.nextLine();

        System.out.println("Agora a sua idade : ");
            int idade2 = Integer.parseInt(ler.nextLine());

        System.out.println("A diferença de idade entre " + nome1 + " e " + nome2 + " e de " + Math.abs(idade1 - idade2) + " anos.");
    }
}
