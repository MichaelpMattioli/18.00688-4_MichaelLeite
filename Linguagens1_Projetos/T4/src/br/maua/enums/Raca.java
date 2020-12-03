package br.maua.enums;

public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ASMODIANO("Asmodiano"),
    HAROS("Haros"),
    ANÃO("Anão");

    private String valor;

    Raca(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
