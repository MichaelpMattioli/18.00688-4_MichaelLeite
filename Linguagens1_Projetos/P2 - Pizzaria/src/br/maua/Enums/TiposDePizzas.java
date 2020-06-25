package br.maua.Enums;

/**
 * Classe responsavel enumerar os tipos de pizzas e seus valores.
 * @author Michael Pedroza Mattioli Leite
 * @since 24/06/2020
 * @version 1.0
 */

public enum TiposDePizzas {
    MARGUERITA(35.90), CALABRESA(35.90), PORTUGUESA(39.90),FRANGO_COM_CAPUTIRY(39.90);

    private double valorDaPizza;

    /**
     * Construtor responsavel por indicar o valor de cada enumeracao.
     * @param valor
     */
    TiposDePizzas(double valor) {
        valorDaPizza = valor;
    }

    /**
     * Método responsavel por retornar o valor contido na enumeracao.
     * @return valor contido na enumeracao
     */

    public double getValorDaPizza() {
        return valorDaPizza;
    }
}
