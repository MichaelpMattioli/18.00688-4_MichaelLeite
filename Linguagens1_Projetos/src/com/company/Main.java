package com.company;

public class Main {

    public static void main(String[] args) {
        Conta c1 = new Conta(500);
        c1.depositar(1000);
        System.out.println("Saldo Atual:" + c1.getSaldo());
        c1.sacar(200);
        System.out.println("Saldo Atual:" + c1.getSaldo());
        c1.depositar(1200);
        System.out.println("Saldo Atual:" + c1.getSaldo());

    }
}
