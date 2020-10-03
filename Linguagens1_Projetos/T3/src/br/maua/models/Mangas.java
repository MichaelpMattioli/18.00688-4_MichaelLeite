package br.maua.models;

public class Mangas {
    private String nome;
    private String sinopse;
    private int quantidadeCapitulos;
    private int quantidadeVolumes;
    private String tipo;
    private float nota;
    private String urlPoster;

    public Mangas(String nome, String sinopse, int quantidadeCapitulos, int quantidadeVolumes, String tipo, float nota, String urlPoster) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.quantidadeCapitulos = quantidadeCapitulos;
        this.quantidadeVolumes = quantidadeVolumes;
        this.tipo = tipo;
        this.nota = nota;
        this.urlPoster = urlPoster;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getQuantidadeCapitulos() {
        return quantidadeCapitulos;
    }

    public int getQuantidadeVolumes() {
        return quantidadeVolumes;
    }

    public String getTipo() {
        return tipo;
    }

    public float getNota() {
        return nota;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

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
