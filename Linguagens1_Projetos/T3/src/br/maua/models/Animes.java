package br.maua.models;


public class Animes {
    private String nome;
    private String sinopse;
    private int quantidadeEpisodios;
    private float nota;

    public Animes(String nome, String sinopse, int quantidadeEpisodios, float nota) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.nota = nota;
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

    @Override
    public String toString() {
        return "nome: " + nome  +
                ", sinopse: " + sinopse +
                ", quantidadeEpisodios: " + quantidadeEpisodios +
                ", nota: " + nota ;
    }
}
