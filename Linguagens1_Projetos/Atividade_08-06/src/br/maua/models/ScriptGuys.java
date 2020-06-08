package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

/**
 * Classe ScriptGuys, classe filha de Membros.
 * @author Gabriel de Laurentis Dias Cardoso e Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public class ScriptGuys extends Membros{
    /**
     * Construtor da classe ScriptGuys.
     * @param usuario Usuario do membro ScriptGuys.
     * @param email Email do membro ScriptGuys.
     */

    public ScriptGuys(String usuario, String email) {
        super(usuario, Cargos.SCRIPT_GUYS, email, "Prazer em ajudar novos amigos de código!", "QU3Ro_S3us_r3curs0s.py");
    }

    /**
     * Estrutura que irá definir qual mensagem será utilizada do membro ScriptGuys.
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
