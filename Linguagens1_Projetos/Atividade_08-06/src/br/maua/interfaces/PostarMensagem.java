package br.maua.interfaces;

import br.maua.enums.Horarios;

/**
 * Interface que será implementada na classe membros, responsavel por postar a mensagem no horario correto.
 * @author Gabriel de Laurentis Dias Cardoso e Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public interface PostarMensagem {
    String PostarMensagem(String horario);
}
