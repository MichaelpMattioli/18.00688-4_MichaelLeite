package br.maua.enums;

public enum Itens {
    VAZIO(0, 0, 0, 0, 0, 0, 0, 0),
    POT_MP(0, 10, 0, 0, 0, 0, 0, 0),
    POT_ATK(0, 0, 10, 0, 0, 0, 0, 0),
    POT_ATKM(0, 0, 0, 10, 0, 0, 0, 0),
    POT_DEF(0, 0, 0, 0, 10, 0, 0, 0),
    POT_DEFM(0, 0, 0, 0, 0, 10, 0, 0),
    POT_VEL(0, 0, 0, 0, 0, 0, 10, 0),
    POT_DES(0, 0, 0, 0, 0, 0, 0, 10);

    private int local;
    private int mana;
    private int ad;
    private int ap;
    private int def;
    private int defM;
    private int velocidade;
    private int destreza;

    Itens(int local, int mana, int ad, int ap, int def, int defM, int velocidade, int destreza) {
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

    public static Itens getItem(String item){
        for(Itens it:Itens.values()){
            if(it.toString().equals(item.toUpperCase())){
                return it;
            }
        }
        return null;
    }
}
