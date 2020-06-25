package br.maua;

import br.maua.Enums.TiposDePizzas;
import br.maua.Model.Pedidos;
import br.maua.Model.Pizzas;
import br.maua.Model.SistemaPrincipal;
import br.maua.Model.Usuario;

public class Main {

    public static void main(String[] args) {
//        SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();
//        sistemaPrincipal.Menu();
        Pizzas pizzas = new Pizzas();
        pizzas.listaDePizzas();


    }
}
