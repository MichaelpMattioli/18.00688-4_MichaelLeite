package br.maua.models;

import br.maua.enums.Equipamentos;
import br.maua.enums.Profissao;
import br.maua.enums.Raca;

/**
 * * Classe responsável por construir um personagem com suas características unicas.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/12/2020
 * @version 1.0
 * */

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

    /**
     * Construtor do Personagem, é a partir desse construtor que se define o que irá conter em cada variável do personagem.
     * @param nome String que representa o nome do personagem.
     * @param raca Enum que representa a raça do personagem.
     * @param profissao Enum que representa a profissão do personagem.
     * @param mana Integer que representa a quantidade de mana do personagem.
     * @param ad Integer que representa a quantidade de ataque fisico do personagem.
     * @param ap Integer que representa a quantidade de ataque mágico do personagem.
     * @param def Integer que representa a quantidade de defesa do personagem.
     * @param defM Integer que representa a quantidade de defesa mágica do personagem.
     * @param velocidade Integer que representa a quantidade de velocidade do personagem.
     * @param destreza Integer que representa a quantidade de destreza do personagem.
     * @param experiencia Integer que representa a quantidade de experiência do personagem.
     * @param nivel Integer que representa o nível do personagem.
     * @param cabeca Enum que representa a equipamento da cabeça do personagem.
     * @param tronco Enum que representa a equipamento do tronco do personagem.
     * @param pernas Enum que representa a equipamento das pernas do personagem.
     * @param pes Enum que representa a equipamento dos pés do personagem.
     */
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
    }

    /**
     * Construtor do Personagem, construtor que apresenta as variáveis de equipamento padrões NONE.
     * @param nome String que representa o nome do personagem.
     * @param raca Enum que representa a raça do personagem.
     * @param profissao Enum que representa a profissão do personagem.
     * @param mana Integer que representa a quantidade de mana do personagem.
     * @param ad Integer que representa a quantidade de ataque fisico do personagem.
     * @param ap Integer que representa a quantidade de ataque mágico do personagem.
     * @param def Integer que representa a quantidade de defesa do personagem.
     * @param defM Integer que representa a quantidade de defesa mágica do personagem.
     * @param velocidade Integer que representa a quantidade de velocidade do personagem.
     * @param destreza Integer que representa a quantidade de destreza do personagem.
     * @param experiencia Integer que representa a quantidade de experiência do personagem.
     * @param nivel Integer que representa o nível do personagem.
     */

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
                '}';
    }
}
