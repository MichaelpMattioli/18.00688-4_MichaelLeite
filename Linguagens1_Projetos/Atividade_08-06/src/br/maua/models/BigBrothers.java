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
    public String PostarMensagem(String mensagem) {
        int x = 0;
        System.out.println("Como você está se sentindo?");
        System.out.println("1 - Carinhoso");
        System.out.println("2 - Malvado");
        Scanner msg = new Scanner(System.in);
        x = msg.nextInt();
        if( x == 1)
            return mensagem + "\n\n" + assinaturaTeddyBear ;
        else
            return mensagem + "\n\n" + assinaturaEvilBear ;

    }
}
