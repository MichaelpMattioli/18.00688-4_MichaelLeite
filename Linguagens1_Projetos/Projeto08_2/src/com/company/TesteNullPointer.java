package com.company;

public class TesteNullPointer {
    public static void main(String[] args) {
        String frase = null;
        String novaFrase = null;
        try {
            frase = null;
            novaFrase = frase.toUpperCase();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Frase Original:" + frase);
        System.out.println("Frase Modificada:" + novaFrase);
    }
}
