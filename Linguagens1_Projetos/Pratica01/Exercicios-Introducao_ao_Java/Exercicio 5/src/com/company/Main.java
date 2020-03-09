package com.company;

import java.util.Scanner;

public class Main {

    public static double Fibonnacci(double num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        if (num > 1)
            return (Fibonnacci(num - 1) + Fibonnacci(num - 2));
        return num;
    }

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Posicao do numero de fibonnacci: ");
        double numero = ler.nextDouble();
        System.out.println(Fibonnacci(numero));


    }
}
