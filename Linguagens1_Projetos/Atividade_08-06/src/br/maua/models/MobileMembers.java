package br.maua.models;

import br.maua.enums.Cargos;

public class MobileMembers extends Membros{
    private String assinaturaHorarioNormal = "HappyCoding!";
    private String assinaturaHoraExtra = "Happy_C0d1ng. Maskers";

    public MobileMembers(String usuario) {
        super(usuario, Cargos.MOBILE_MEMBERS);
    }

    @Override
    public String PostarMensagem(int horario) {
        if( horario == 1)
            return  assinaturaHorarioNormal ;
        else
            return assinaturaHoraExtra ;
    }
}
