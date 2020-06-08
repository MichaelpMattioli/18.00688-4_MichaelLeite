package com.company;

//mport Pacote.Dog;
import Pacote.QualquerCoisa;

public class Main {

    public static void main(String[] args) {
//        QualquerCoisa meuQualquerCoisa = new QualquerCoisa();
//        Dog dog1 = new Dog(30);
//        Pacote.Dog dog2 = new Pacote.Dog(3);
//        dog1.bark();
//        meuQualquerCoisa.ola();
//        dog2.bark();
        System.out.println("inicio do main");
        metodo1();
        System.out.println("Fim do main");
    }
    static void metodo1() {
        System.out.println("inicio do metodo1");
        metodo2();
        System.out.println("fim do metodo1");
    }

    static void metodo2(){
        System.out.println("inicio do metodo2");
        int[] array = new int[10];
        for (int i = 0; i <= 15; i++){
            array[i] = i;
            System.out.println(i);
        }
        System.out.println("fim do metodo2");
    }
}
