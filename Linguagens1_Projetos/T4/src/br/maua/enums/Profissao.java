package br.maua.enums;

public enum Profissao {
    ARQUEIRA("Arqueira"),  CACADOR("Caçador"), CACADOR_DE_RECOMPENSAS("Caçador de Recompensas"),
    MAGO("Mago"), ALQUIMISTA("Alquimista"), FEITICEIRO("Feiticeiro"), ARQUIMAGO("Arquimago"), SACERDOTE("Sacerdote"),
    NINJA("Ninja"), MERCENARIO("Mercenario"),
    GUERREIRO("Guerreiro"), ESPADACHIM("Espadachim"), GLADIADOR("Gladiador"),
    DEFENSOR("Defensor"), GUARDIAO("Guardiao"), PALADINO("Paladino"), TEMPLARIO("Templario"),
    TECNOMAGO("Tecnomago");


    private String valor;

    Profissao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Profissao getProfissao(String profissao){
        for(Profissao prof:Profissao.values()){
            if(prof.toString().equals(profissao.toUpperCase())){
                return prof;
            }
        }
        return null;
    }

}
