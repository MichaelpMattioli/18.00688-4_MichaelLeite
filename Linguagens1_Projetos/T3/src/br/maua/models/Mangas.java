package br.maua.models;

/**
 * * Classe responsavel por modelar os dados de cada mangá.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class Mangas {
    private String nome;
    private String sinopse;
    private Integer quantidadeCapitulos;
    private Integer quantidadeVolumes;
    private String tipo;
    private Float nota;
    private String urlPoster;

    /**
     * Construtor da classe Mangas
     * @param nome String que apresenta o nome do mangá
     * @param sinopse String que aparesenta a sinopse do mangá
     * @param quantidadeCapitulos Integer que apresenta a quantidade de capítulos do mangá.
     * @param quantidadeVolumes Integer que apresenta a quantidade de volumes do mangá.
     * @param tipo String que apresenta o tipo de mangá.
     * @param nota Float que apresenta a nota do mangá.
     * @param urlPoster String que apresenta o URL do poster no mangá.
     */

    public Mangas(String nome, String sinopse, int quantidadeCapitulos, int quantidadeVolumes, String tipo, float nota, String urlPoster) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantidadeCapitulos = quantidadeCapitulos;
        this.quantidadeVolumes = quantidadeVolumes;
        this.tipo = tipo;
        this.nota = nota;
        this.urlPoster = urlPoster;
    }

    /**
     * Função para obter o nome do Mangá.
     * @return retorna o nome do Mangá.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função para obter a sinopse do Mangá.
     * @return retorna a sinopse do Mangá.
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * Função para obter a quantidade de capitulos do Mangá.
     * @return retorna a quantidade de capitulos do Mangá.
     */
    public int getQuantidadeCapitulos() {
        return quantidadeCapitulos;
    }

    /**
     * Função para obter a quantidade de volumes do Mangá.
     * @return retorna a quantidade de volumes do Mangá.
     */
    public int getQuantidadeVolumes() {
        return quantidadeVolumes;
    }

    /**
     * Função para obter o tipo do Mangá.
     * @return retorna o tipo do Mangá.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Função para obter a nota do Mangá.
     * @return retorna a nota do Mangá.
     */
    public float getNota() {
        return nota;
    }

    /**
     * Função para obter a URL do Mangá.
     * @return retorna a URL do Mangá.
     */
    public String getUrlPoster() {
        return urlPoster;
    }

    /**
     * Função para formatar em formato de texto as informações do Mangá.
     * @return retorna as informações do Mangá de forma formata para texto.
     */
    @Override
    public String toString() {
        return "Manga - " +
                "nome: " + nome +
                ", sinopse: " + sinopse +
                ", quantidadeCapitulos: " + quantidadeCapitulos +
                ", quantidadeVolumes: " + quantidadeVolumes +
                ", tipo: " + tipo +
                ", nota: " + nota +
                ", urlPoster: " + urlPoster;
    }
}
