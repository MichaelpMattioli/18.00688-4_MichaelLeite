package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o primeiro numero do intervalo: ");
            double num1 = ler.nextDouble();


        System.out.println("Digite o segundo numero do intervalo: ");
            double num2 = ler.nextDouble();

        System.out.println("\nA soma e: " + SomaIntervalo(num1,num2));
        System.out.println("O produto e: " + ProdutoIntervalo(num1,num2));


    }

    private static double SomaIntervalo(double numero1, double numero2){
        double soma = 0;
        if ( numero1 <= numero2 ){
            soma = numero1 + SomaIntervalo(numero1 + 1,numero2);
        }
        return soma;
    }


    private static double ProdutoIntervalo(double numero1, double numero2){
        double produto = 1;
        if ( numero1 <= numero2){
            produto = numero1 * ProdutoIntervalo(numero1 + 1,numero2);
        }
        return produto;
    }
}
