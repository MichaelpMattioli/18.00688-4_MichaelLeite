package br.maua.models;

import br.maua.enums.Cargos;

public class BigBrothers extends Membros{

    public BigBrothers(String usuario, Cargos cargos) {
        super(usuario, cargos);
    }

    private String assinaturaTeddyBear = "Sempre ajudando as pessoas membros ou não S2!";
    private String assinaturaEvilBear = "...";

    private void cadastrarMembro( Membros membros ){
        
    }

    @Override
    public String PostarMensagem(String mensagem) {
        return null;
    }
}
