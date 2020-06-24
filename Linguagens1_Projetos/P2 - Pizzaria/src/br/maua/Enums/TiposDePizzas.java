package br.maua.Enums;

public enum TiposDePizzas {
    MARGUERITA(35.90), CALABRESA(35.90), PORTUGUESA(39.90);

    private double valorDaPizza;
    TiposDePizzas(double valor) {
        valorDaPizza = valor;
    }

    public double getValorDaPizza() {
        return valorDaPizza;
    }
}
