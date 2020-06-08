package br.maua.models;

import br.maua.enums.Cargos;

import java.util.Scanner;

public class BigBrothers extends Membros{
    private String assinaturaTeddyBear = "Sempre ajudando as pessoas membros ou não S2!";
    private String assinaturaEvilBear = "...";

    public BigBrothers(String usuario) {
        super(usuario, Cargos.BIG_BROTHERS);
    }

    @Override
    public String PostarMensagem(int horario) {
        if( horario == 1)
            return  assinaturaTeddyBear ;
        else
            return assinaturaEvilBear ;

    }
}
