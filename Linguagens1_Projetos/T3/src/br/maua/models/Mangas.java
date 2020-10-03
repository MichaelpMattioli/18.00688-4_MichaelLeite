package br.maua.models;

public class Mangas {
    private String nome;
    private String sinopse;
    private Integer quantidadeCapitulos;
    private Integer quantidadeVolumes;
    private String tipo;
    private Float nota;
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

    public Mangas(String nome) {
        this.nome = nome;
        this.sinopse = null;
        this.quantidadeCapitulos = null;
        this.quantidadeVolumes = null;
        this.tipo = null;
        this.nota = null;
        this.urlPoster = null;
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
