package com.company;

public class Conta {

    public Conta (double saldoInicial){
        this.saldo = saldoInicial;
    }

    private double saldo;
     public void sacar (double valor){
        if(saldo >= valor)
            saldo -= valor;
    }

    public void depositar (double valor){
        this.saldo  +=valor;
    }

    public double getSaldo(){
         return this.saldo;
    }
}
