package br.maua.models;

import br.maua.enums.Profissao;
import br.maua.enums.Raca;


public class Personagem {
    private String nome;
    private Raca raca;
    private Profissao profissao;
    private Integer mana;
    private Integer ad;
    private Integer ap;
    private Integer def;
    private Integer defM;
    private Integer velocidade;
    private Integer destreza;
    private Integer experiencia;
    private Integer nivel;

    public Personagem(String nome, Raca raca, Profissao profissao, Integer mana, Integer ad, Integer ap, Integer def, Integer defM, Integer velocidade, Integer destreza, Integer experiencia, Integer nivel) {
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
        this.mana = mana;
        this.ad = ad;
        this.ap = ap;
        this.def = def;
        this.defM = defM;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.experiencia = experiencia;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public Raca getRaca() {
        return raca;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public Integer getMana() {
        return mana;
    }

    public Integer getAd() {
        return ad;
    }

    public Integer getAp() {
        return ap;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getDefM() {
        return defM;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public Integer getNivel() {
        return nivel;
    }


    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", raca=" + raca +
                ", profissao=" + profissao +
                ", mana=" + mana +
                ", ad=" + ad +
                ", ap=" + ap +
                ", def=" + def +
                ", defM=" + defM +
                ", velocidade=" + velocidade +
                ", destreza=" + destreza +
                ", experiencia=" + experiencia +
                ", nivel=" + nivel +
                '}';
    }
}
