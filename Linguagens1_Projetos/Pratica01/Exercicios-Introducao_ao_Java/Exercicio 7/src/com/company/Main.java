package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite um valor numerico : ");
        String num = ler.next();
        try {
            double testenum = Double.parseDouble(num.replace(",","."));
            System.out.println("A somatoria de todos os algarismos e:  " + SomaAlgarismosStrings(num, 0));
        }
        catch ( Exception e){
            System.out.println("Não e numerico.");
        }
    }

    private static double SomaAlgarismosStrings(String stringnumerica ,int num){
        double soma = 0;
        if ( num < stringnumerica.replace(".","").replace(",","").length() ){
            soma = Character.getNumericValue(stringnumerica.charAt(num)) + SomaAlgarismosStrings(stringnumerica.replace(".","").replace(",","") ,num + 1);
        }
        return soma;
    }
}