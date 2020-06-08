package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

public class HeavyLifters extends Membros{

    public HeavyLifters(String usuario, String email) {
        super(usuario, Cargos.HEAVY_LIFTERS,email , "Podem contar conosco!", "Happy_C0d1ng. Maskers");
    }

    @Override
    public String PostarMensagem(String horario) {
        if(horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
