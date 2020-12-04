package br.maua.enums;

import java.util.ArrayList;

/**
 * * Classe responsável por enumerar todos os equipamentos disponiveis.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/11/2020
 * @version 1.0
 * */

public enum Equipamentos {
    NONE(0, 0, 0, 0, 0, 0, 0, 0),
    ELMO_DE_COURO(1, 1, 0, 0, 3, 1, 1, 0),
    PEITORAL_DE_COURO(2, 2, 0, 0, 3, 1, 1, 0),
    CALCAS_DE_COURO(3, 1, 0, 0, 3, 1, 1, 0),
    BOTAS_DE_COURO(4, 1, 0, 0, 3, 1, 1, 0),
    ELMO_DE_FERRO(1, 3, 0, 0, 3, 1, 1, 0),
    PEITORAL_DE_FERRO(2, 5, 0, 0, 3, 1, 1, 0),
    CALCAS_DE_FERRO(3, 4, 0, 0, 3, 1, 1, 0),
    BOTAS_DE_FERRO(4, 2, 0, 0, 3, 1, 1, 0),
    ELMO_DE_PLATINA(1, 16, 0, 0, 3, 1, 1, 0),
    PEITORAL_DE_PLATINA(2, 30, 0, 0, 3, 1, 1, 0),
    CALCAS_DE_PLATINA(3, 22, 0, 0, 3, 1, 1, 0),
    BOTAS_DE_PLATINA(4, 14, 0, 0, 3, 1, 1, 0);

    private int local;
    private int mana;
    private int ad;
    private int ap;
    private int def;
    private int defM;
    private int velocidade;
    private int destreza;

    Equipamentos(int local, int mana, int ad, int ap, int def, int defM, int velocidade, int destreza) {
        this.local = local;
        this.mana = mana;
        this.ad = ad;
        this.ap = ap;
        this.def = def;
        this.defM = defM;
        this.velocidade = velocidade;
        this.destreza = destreza;
    }

    public int getLocal() {
        return local;
    }

    public int getMana() {
        return mana;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }

    public int getDef() {
        return def;
    }

    public int getDefM() {
        return defM;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public static Equipamentos getEquipamento(String equipamento){
        for(Equipamentos equip:Equipamentos.values()){
            if(equip.toString().equals(equipamento.toUpperCase())){
                return equip;
            }
        }
        return null;
    }
}
