package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

/**
 * Classe HeavyLifters, classe filha de Membros
 * @author Gabriel de Laurentis Dias Cardoso & Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public class HeavyLifters extends Membros{
    /**
     * Construtor da classe HeavyLifters.
     * @param usuario Usuario do membro HeavyLifters.
     * @param email Email do membro HeavyLifters.
     */

    public HeavyLifters(String usuario, String email) {
        super(usuario, Cargos.HEAVY_LIFTERS,email , "Podem contar conosco!", "Happy_C0d1ng. Maskers");
    }

    /**
     * Estrutura que irá definir qual mensagem será utilizada do membro HeavyLifters.
     * @param horario Horario em que o membro está trabalhando.
     * @return Retorna a assinatura dependendo de qual horario.
     */

    @Override
    public String PostarMensagem(String horario) {
        if(horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
