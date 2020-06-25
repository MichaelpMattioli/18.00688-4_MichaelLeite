package br.maua.Model;

import br.maua.Enums.TiposDePizzas;

/**
 * Classe responsavel por gerenciar os tipos de pizzas, apartir do nome da pizza, é possivel já saber o seu valor
 * através dos Enums já pre-definidos, assim temos uma classe que representa várias pizzas de sabores e preços
 * diferentes.
 * @author Michael Pedroza Mattioli Leite
 * @since 25/06/2020
 * @version 1.0
 */

public class Pizzas {
    private TiposDePizzas nome;
    private double valor;

    /**
     * Construtor do da Classe, com ele é possivel saber qual é o valor da pizza ao colocar o tipo de
     * sabor já presente no enum.
     * @param nome Uma das enumeração de uma pizza enumarada no Enum TiposDePizzas.
     */
    public Pizzas(TiposDePizzas nome) {
        this.nome = nome;
        this.valor = this.nome.getValorDaPizza();
    }

    /**
     * Getter do valor de um sabor especifico de uma pizza.
     * @return Um valor de uma pizza na qual ja esta pre-estabelecida.
     */

    public double getValor() {
        return valor;
    }

    /**
     * toString, responsavel pela construção gráfica, foi utilizado para listar as pizzas de um pedido.
     * @return Uma String com a informação do nome da pizza
     */

    @Override
    public String toString() {
        return  nome + " ";
    }

}