package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

public class MobileMembers extends Membros{


    public MobileMembers(String usuario, String email) {
        super(usuario, Cargos.MOBILE_MEMBERS,email , "HappyCoding!","Happy_C0d1ng. Maskers");
    }

    @Override
    public String PostarMensagem(String horario) {
        if( horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra() ;
    }
}
