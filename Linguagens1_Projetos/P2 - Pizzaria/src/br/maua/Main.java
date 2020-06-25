package br.maua;

import br.maua.Model.SistemaPrincipal;

/**
 * Classe ponto de entrada da aplicação base, ela é responsável por iniciar a aplicação.
 * @author Michael Pedroza Mattioli Leite
 * @since 25/06/2020
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();
        sistemaPrincipal.Sistema();
    }
}
