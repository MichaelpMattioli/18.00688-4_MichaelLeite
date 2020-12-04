package br.maua.models;

import br.maua.enums.Equipamentos;
import br.maua.enums.Itens;
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
    private Equipamentos cabeca;
    private Equipamentos tronco;
    private Equipamentos pernas;
    private Equipamentos pes;
    private Itens[] itensDisponiveis;

    public Personagem(String nome, Raca raca, Profissao profissao, Integer mana, Integer ad, Integer ap, Integer def, Integer defM, Integer velocidade, Integer destreza, Integer experiencia, Integer nivel, Equipamentos cabeca, Equipamentos tronco, Equipamentos pernas, Equipamentos pes, Itens itens) {
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
        this.cabeca = cabeca;
        this.tronco = tronco;
        this.pernas = pernas;
        this.pes = pes;
        this.itensDisponiveis = new Itens[] {itens};
    }

    public Personagem(String nome, Raca raca, Profissao profissao, Integer mana, Integer ad, Integer ap, Integer def, Integer defM, Integer velocidade, Integer destreza, Integer experiencia, Integer nivel, Equipamentos cabeca, Equipamentos tronco, Equipamentos pernas, Equipamentos pes) {
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
        this.cabeca = cabeca;
        this.tronco = tronco;
        this.pernas = pernas;
        this.pes = pes;
        this.itensDisponiveis = new Itens[] {Itens.VAZIO};
    }

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
        this.cabeca = Equipamentos.NONE;
        this.tronco = Equipamentos.NONE;
        this.pernas = Equipamentos.NONE;
        this.pes = Equipamentos.NONE;
        this.itensDisponiveis = new Itens[] {Itens.VAZIO};
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

    public Equipamentos getCabeca() {
        return cabeca;
    }

    public Equipamentos getTronco() {
        return tronco;
    }

    public Equipamentos getPernas() {
        return pernas;
    }

    public Equipamentos getPes() {
        return pes;
    }

    public Itens[] getItensDisponiveis() {
        return itensDisponiveis;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome:'" + nome + '\'' +
                ", raca:" + raca.getValor() +
                ", profissao:" + profissao.getValor() +
                ", mana:" + mana +
                ", ad:" + ad +
                ", ap:" + ap +
                ", def:" + def +
                ", defM:" + defM +
                ", velocidade:" + velocidade +
                ", destreza:" + destreza +
                ", experiencia:" + experiencia +
                ", nivel:" + nivel +
                ", armadura{"+
                    "cabeca:" + cabeca.toString().replace("_", " ").toLowerCase() +
                    ", tronco:" + tronco.toString().replace("_", " ").toLowerCase() +
                    ", perna:" + pernas.toString().replace("_", " ").toLowerCase() +
                    ", pes:" + pes.toString().replace("_", " ").toLowerCase() +
                "}" +
                ", item{"+ itensDisponiveis + "}" +
                '}';
    }

}
