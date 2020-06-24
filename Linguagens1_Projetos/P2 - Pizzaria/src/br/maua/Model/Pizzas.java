package br.maua.Model;

import br.maua.Enums.TiposDePizzas;

public class Pizzas {
    private TiposDePizzas nome;
    private double valor;

    public Pizzas(TiposDePizzas nome) {
        this.nome = nome;
        this.valor = this.nome.getValorDaPizza();
    }

    public TiposDePizzas getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
