package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("inicio do main");
        metodo1();
        System.out.println("fim do main");
    }

    private static void metodo1() {
        System.out.println("inicio do metodo1");
        try {
            metodo2();
        }
        catch (Exception excepiton){
            System.out.println("Algo inexperado aconteceu!");
            System.out.println(excepiton.getMessage());
        }
        System.out.println("fim do metodo1");
    }

    private static void metodo2() throws Exception{
        System.out.println("inicio do metodo2");
        int[] array = new int[10];
        try {
            for (int i = 0; i <= 15; i++) {
                array[i] = i;
                System.out.println(i);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Tentou acessar posicao invalida:");
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Deu ruim aqui");
        }
    }
}
