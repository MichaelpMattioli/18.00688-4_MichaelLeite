package Exemplo01;

public class Conta {
    //Atributos da classe
    public int numero;
    public Cliente cliente;
    public double saldo;

    //Métodos da classe
    boolean sacar( double valor ){
        if (this.saldo < valor)
            return false;
        else {
            this.saldo -= valor ;
            return true;
        }
    }
    void depositar(double valor){
        this.saldo += valor;
    }
    boolean transferirDinheiro(Conta destino, double valor){
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        else
            return false;
    }
    void visualizarSaldo(){
        System.out.println("Saldo: " + this.saldo);
    }
}

