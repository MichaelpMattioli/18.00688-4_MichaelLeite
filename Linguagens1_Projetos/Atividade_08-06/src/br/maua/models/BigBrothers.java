package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

/**
 * Classe BigBrothers, classe filha de Membros
 * @author Gabriel de Laurentis Dias Cardoso e Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public class BigBrothers extends Membros{

    /**
     * Construtor da classe BigBrothers.
     * @param usuario Usuario do membro BigBrothers.
     * @param email Email do membro BigBrothers.
     */

    public BigBrothers(String usuario, String email) {
        super(usuario, Cargos.BIG_BROTHERS,email , "Sempre ajudando as pessoas membros ou não S2!", "...");
    }

    /**
     * Estrutura que irá definir qual mensagem será utilizada do membro BigBrothers.
     * @param horario Horario em que o membro está trabalhando.
     * @return Retorna a assinatura dependendo de qual horario.
     */
    @Override
    public String PostarMensagem(String horario) {
        if( horario.equals(String.valueOf(Horarios.REGULAR)))
            return  getAssinaturaHorarioNormal() ;
        else
            return getAssinaturaHoraExtra();
    }
}
