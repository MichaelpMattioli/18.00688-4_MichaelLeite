package com.company;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a frase : ");
        String frase = ler.nextLine();

        String fraseInvertida = new StringBuilder(frase).reverse().toString();

        if ( frase.equals(fraseInvertida)){
            System.out.println("A frase é um palindromo");
        }
        else {
            System.out.println("A frase não é um palindromo");
        }
    }
}
