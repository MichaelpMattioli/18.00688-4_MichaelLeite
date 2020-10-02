package br.maua.models;


public class Animes {
    private String nome;
    private String sinopse;
    private int quantidadeEpisodios;
    private float nota;
    private String urlPoster;

    public Animes(String nome, String sinopse, int quantidadeEpisodios, float nota, String urlPoster) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.nota = nota;
        this.urlPoster = urlPoster;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    public float getNota() {
        return nota;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    @Override
    public String toString() {
        return "nome: " + nome  +
                ", sinopse: " + sinopse +
                ", quantidadeEpisodios: " + quantidadeEpisodios +
                ", nota: " + nota ;
    }
}
