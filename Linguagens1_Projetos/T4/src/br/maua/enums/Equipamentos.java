package br.maua.enums;

public enum Equipamentos {
    NONE(0),
    ELMO_DE_COURO(1),
    PEITORAL_DE_COURO(2),
    CALCAS_DE_COURO(3),
    BOTAS_DE_COURO(4),
    ELMO_DE_FERRO(1),
    PEITORAL_DE_FERRO(2),
    CALCAS_DE_FERRO(3),
    BOTAS_DE_FERRO(4),
    ELMO_DE_PLATINA(1),
    PEITORAL_DE_PLATINA(2),
    CALCAS_DE_PLATINA(3),
    BOTAS_DE_PLATINA(4);

    private int valor;

    Equipamentos(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
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
