package br.maua.enums;

public enum Raca {
    HUMANO,
    ELFO,
    ASMODIANO,
    HAROS,
    ANÃO;

    public static Raca getRaca(String raca){
        for(Raca rac:Raca.values()){
            if(rac.toString().equals(raca.toUpperCase())){
                return rac;
            }
        }
        return null;
    }
}
