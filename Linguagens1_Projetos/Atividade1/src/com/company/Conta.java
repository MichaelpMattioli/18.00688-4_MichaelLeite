// Michael Pedroza Mattioli Leite   RA: 18.00688-4
package com.company;

public class Conta {
    private int idConta;
    private double saldo;
    private Usuario usuario;
    public int i=0;

    public Conta(Usuario usuario) {
        this.usuario = usuario;
        this.idConta = i+1;
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
