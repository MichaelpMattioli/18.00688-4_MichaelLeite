package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.interfaces.PostarMensagem;

public abstract class Membros implements PostarMensagem {
    private String usuario;
    private Cargos cargos;

    public Membros(String usuario, Cargos cargos) {
        this.usuario = usuario;
        this.cargos = cargos;
    }

    public String getUsuario() {
        return usuario;
    }

    public Cargos getCargos() {
        return cargos;
    }
}
