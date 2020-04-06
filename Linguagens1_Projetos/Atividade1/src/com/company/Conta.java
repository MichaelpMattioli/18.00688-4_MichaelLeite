// Michael Pedroza Mattioli Leite   RA: 18.00688-4
package com.company;

public class Conta {
    private static int totalDeContas += 1;
    private int idConta = totalDeContas;
    private double saldo;
    private Usuario usuario;


    public Conta(Usuario usuario) {
        this.usuario = usuario;
        this.idConta;
        saldo = 0;
    }

    public int getIdConta() {
        return idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean sacar( double valor ){
        if (this.saldo < valor)
            return false;
        else {
            this.saldo -= valor ;
            return true;
        }
    }
}
