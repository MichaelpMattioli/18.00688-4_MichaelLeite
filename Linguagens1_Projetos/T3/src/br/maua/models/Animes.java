package br.maua.models;

/**
 * * Classe responsavel por modelar os dados de cada Anime.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */
public class Animes {
    private String nome;
    private String sinopse;
    private Integer quantidadeEpisodios;
    private Float nota;
    private String urlPoster;

    /**
     * Construtor de Animes
     * @param nome nome atribuido ao anime.
     * @param sinopse sinopse atribuida ao anime.
     * @param quantidadeEpisodios quantidade de episodios atribuido ao anime.
     * @param nota nota atribuida ao anime.
     * @param urlPoster url atribuida ao anime.
     */
    public Animes(String nome, String sinopse, int quantidadeEpisodios, float nota, String urlPoster) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.nota = nota;
        this.urlPoster = urlPoster;
    }

    /**
     * Função para obter o nome do anime.
     * @return retorna o nome do anime.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função para obter a Sinopse do anime.
     * @return retorna a sinopse do anime.
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * Função para obter a quantidade de episodios.
     * @return retorna a quantidade de episodios do anime.
     */
    public int getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    /**
     * Função para obter a nota do anime.
     * @return retorna a nota atribuida ao anime.
     */
    public float getNota() {
        return nota;
    }

    /**
     * Função para obter a Url do anime.
     * @return retorna a URL atribuida ao anime.
     */
    public String getUrlPoster() {
        return urlPoster;
    }

    /**
     * Função para formatar em formato de texto as informações do anime.
     * @return retorna as informações do anime de forma formata para texto.
     */
    @Override
    public String toString() {
        return "Anime - " +
                "nome: " + nome +
                ", sinopse: " + sinopse +
                ", quantidadeEpisodios: " + quantidadeEpisodios +
                ", nota: " + nota +
                ", urlPoster: " + urlPoster;
    }
}
