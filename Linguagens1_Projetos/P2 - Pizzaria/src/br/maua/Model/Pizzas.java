package br.maua.Model;

import br.maua.Enums.TiposDePizzas;

import java.util.ArrayList;


public class Pizzas {
    private TiposDePizzas nome;
    private double valor;

    public Pizzas(TiposDePizzas nome) {
        this.nome = nome;
        this.valor = this.nome.getValorDaPizza();
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return " " + nome + " ";
    }
}