package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

import java.util.Scanner;

public class BigBrothers extends Membros{

    public BigBrothers(String usuario, String email) {
        super(usuario, Cargos.BIG_BROTHERS,email , "Sempre ajudando as pessoas membros ou não S2!", "...");
    }

    @Override
    public String PostarMensagem(String horario) {
        if( horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
