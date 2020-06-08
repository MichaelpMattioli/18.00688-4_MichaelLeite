package br.maua.models;

import br.maua.enums.Cargos;

public class MobileMembers extends Membros{

    public MobileMembers(String usuario, Cargos cargos) {
        super(usuario, cargos);
    }

    @Override
    public String PostarMensagem(String mensagem) {

        return null;
    }
}
