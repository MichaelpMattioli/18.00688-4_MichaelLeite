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

    public CartasPokemon(String id) {
        this(id,null,null,null,null,null);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaridade() {
        return raridade;
    }

    public String getSerie() {
        return serie;
    }

    public String getColecao() {
        return colecao;
    }

    public String getURL() {
        return URL;
    }

    @Override
    public String toString() {
        return  "ID=" + id + "\t" +
                ", nome=" + nome + "\t" +
                ", raridade=" + raridade + "\t" +
                ", serie=" + serie + "\t" +
                ", colecao=" + colecao;
    }
}
