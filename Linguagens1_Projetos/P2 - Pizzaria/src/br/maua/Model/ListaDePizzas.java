package br.maua.Model;

import br.maua.Enums.TiposDePizzas;

import java.util.ArrayList;
import java.util.List;

public class ListaDePizzas {
    private List<Pizzas> tiposDePizzas;

    public void listaDePizzas() {this.tiposDePizzas = criarListaDePizzas()};

    private List<Pizzas> criarListaDePizzas(){
        List<Pizzas> listaDePizzas = new ArrayList<>();
        for (TiposDePizzas pizza : TiposDePizzas.values()) {
            for( int i = 0; i < TiposDePizzas.values().length; i++)
            listaDePizzas.add(new Pizzas(TiposDePizzas.values()[i]));
        }
        return listaDePizzas;
    }

    public List<Pizzas> getTiposDePizzas() {
        return tiposDePizzas;
    }

    public void mostrarSaboresDePizza(){
        for( int i = 0; i < TiposDePizzas.values().length; i++)
            System.out.println(TiposDePizzas.values()[i]));
    }
}