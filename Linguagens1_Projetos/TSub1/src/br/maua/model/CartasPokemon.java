package br.maua.model;
/**
 * * Classe responsavel por modelar os dados de cada carta pokemon.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */
public class CartasPokemon {
    private String id;
    private String nome;
    private String raridade;
    private String serie;
    private String colecao;
    private String URL;

    /**
     * Construtor da classe CartasPokemon
     * @param id Uma String que deve informar o ID da carta
     * @param nome Uma String que deve informar o Nome da carta
     * @param raridade Uma String que deve informar a Raridade da carta
     * @param serie Uma String que deve informar a Serie da carta
     * @param colecao Uma String que deve informar a Coleção da carta
     * @param URL Uma String que deve informar o URL da imagem da carta
     */
    public CartasPokemon(String id, String nome, String raridade, String serie, String colecao, String URL) {
        this.id = id;
        this.nome = nome;
        this.raridade = raridade;
        this.serie = serie;
        this.colecao = colecao;
        this.URL = URL;
    }

    /**
     * Construtor da classe CartasPokemon com apenas o id sendo informado
     * @param id String com as informações do id da carta
     */

    public CartasPokemon(String id) {
        this(id,null,null,null,null,null);
    }

    /**
     * Get ID da carta
     * @return String
     */

    public String getId() {
        return id;
    }

    /**
     * Get o Nome da carta
     * @return String
     */

    public String getNome() {
        return nome;
    }

    /**
     * Get a Raridade da carta
     * @return String
     */

    public String getRaridade() {
        return raridade;
    }

    /**
     * Get a Serie da carta
     * @return String
     */

    public String getSerie() {
        return serie;
    }

    /**
     * Get a coleção da carta
     * @return String
     */

    public String getColecao() {
        return colecao;
    }

    /**
     * Get a URL da imagem da carta
     * @return String
     */

    public String getURL() {
        return URL;
    }

    /**
     * toString dos dados que estão no construtor da classe
     * @return String
     */

    @Override
    public String toString() {
        return  "ID=" + id  +
                ", nome=" + nome +
                ", raridade=" + raridade +
                ", serie=" + serie +
                ", colecao=" + colecao +
                ", URL=" + URL;
    }
}
