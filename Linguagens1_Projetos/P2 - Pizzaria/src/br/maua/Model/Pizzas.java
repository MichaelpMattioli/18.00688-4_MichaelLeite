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

    public Pizzas() {
        this.nome = nome;
        this.valor = this.nome.getValorDaPizza();
    }

    public TiposDePizzas getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void listaDePizzas(){
        ArrayList<Pizzas> pizzas = new ArrayList<>();
        int i;
        for(i = 0; i < TiposDePizzas.values().length; i++){
            pizzas.add(new Pizzas(TiposDePizzas.values()[i]));
        }
        for (Pizzas sabor: pizzas) {
            System.out.println(sabor.getNome());
        }
    }
}
