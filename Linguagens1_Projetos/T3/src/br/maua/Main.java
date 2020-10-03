//Michael Pedroza Mattioli Leite RA: 18.00688-4

package br.maua;

import br.maua.aplicacoes.AplicacaoDAO;

public class Main {

    public static void main(String[] args) throws Exception {
        AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
        aplicacaoDAO.run();
    }
}
