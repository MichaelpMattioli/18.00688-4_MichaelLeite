package br.maua.models;

import br.maua.enums.Cargos;

public class MobileMembers extends Membros{


    public MobileMembers(String usuario, String email) {
        super(usuario, Cargos.MOBILE_MEMBERS,email , "HappyCoding!","Happy_C0d1ng. Maskers");
    }

    @Override
    public String PostarMensagem(int horario) {
        if( horario == 1)
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra() ;
    }
}
