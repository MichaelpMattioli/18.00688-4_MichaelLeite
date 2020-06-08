package br.maua.models;

import br.maua.enums.Cargos;

public class HeavyLifters extends Membros{

    public HeavyLifters(String usuario, String email) {
        super(usuario, Cargos.HEAVY_LIFTERS,email , "Podem contar conosco!", "Happy_C0d1ng. Maskers");
    }

    @Override
    public String PostarMensagem(int horario) {
        if( horario == 1)
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
