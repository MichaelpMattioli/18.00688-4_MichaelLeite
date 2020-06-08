package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

public class ScriptGuys extends Membros{

    public ScriptGuys(String usuario, String email) {
        super(usuario, Cargos.SCRIPT_GUYS, email, "Prazer em ajudar novos amigos de código!", "QU3Ro_S3us_r3curs0s.py");
    }

    @Override
    public String PostarMensagem(String horario) {
        if( horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
