package com.company;

public class Gerente {
    //Isso, denovo, nao oarece ser a coisa correta a se fazer!
    private double salarioBase;
    private double comissao;

    //Construtor
    public Gerente(double salarioBase){
        this.salarioBase = salarioBase;
        this.comissao = 0.10;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public double getSalarioFinal(double totalVendasMes){
        return salarioBase + comissao * totalVendasMes + 0.5 * salarioBase;
    }

    public boolean darAumento(Vendedor vendedor, double aumento){
        double novoSalarioBase = vendedor.getSalarioBase()*( 1.0 + aumento);
        return vendedor.setSalarioBase(novoSalarioBase, this);
    }
}
