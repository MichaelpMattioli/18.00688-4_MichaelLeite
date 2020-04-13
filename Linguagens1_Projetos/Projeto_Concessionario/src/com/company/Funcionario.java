package com.company;

public class Funcionario {
    private static int contadorDeFuncionarios;
    protected double salarioBase;
    protected double comissao;

    //Construtor
    public Funcionario(double salarioBase){
        this.salarioBase = salarioBase;
        this.comissao = 0.05;
        Funcionario.contadorDeFuncionarios +=1;
    }

    public Funcionario(double salarioBase, double comissao) {
        this.salarioBase = salarioBase;
        this.comissao = comissao;
        Funcionario.contadorDeFuncionarios +=1;
    }

    public double bonusExtraMensal(double totalVendasMes){
        return 0.05*totalVendasMes/contadorDeFuncionarios;
    }

    public int getContadorDeFuncionarios(){ return contadorDeFuncionarios; }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public double getSalarioFinal(double totalVendasMes){
        return salarioBase + comissao*totalVendasMes + bonusExtraMensal(totalVendasMes);
    }
}
