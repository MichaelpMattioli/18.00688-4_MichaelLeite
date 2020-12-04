//Michael Pedroza Mattioli Leite RA: 18.00688-4
// José Guilherme Martins dos Santos RA: 18.00135-0

/**
 * * Classe responsável por incializar o programa.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/12/2020
 * @version 1.0
 * */

package br.maua;
import br.maua.aplicacoes.AplicacaoDAO;

public class Main {

    public static void main(String[] args) {
        AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
        aplicacaoDAO.run();
    }
}
