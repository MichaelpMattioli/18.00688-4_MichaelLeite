// Michael Pedroza Mattioli Leite RA: 18.00688-4
// Gabriel de Laurentis Dias Cardoso RA: 18.00477-6

package br.maua;

import br.maua.models.BigBrothers;
import br.maua.models.Menus;

public class Main {

    public static void main(String[] args) {
        BigBrothers bigBrothers = new BigBrothers("Xmen");
        bigBrothers.PostarMensagem("Ola");
        Menus menu = new Menus();
    }
}
