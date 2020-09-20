package br.maua.model;

public class CartasPokemon {
    private String id;
    private String nome;
    private String raridade;
    private String serie;
    private String colecao;
    private String URL;

    public CartasPokemon(String id, String nome, String raridade, String serie, String colecao, String URL) {
        this.id = id;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
        this.colecao = colecao;
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "CartaPokemon{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", raridade='" + raridade + '\'' +
                ", serie='" + serie + '\'' +
                ", colecao='" + colecao + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}