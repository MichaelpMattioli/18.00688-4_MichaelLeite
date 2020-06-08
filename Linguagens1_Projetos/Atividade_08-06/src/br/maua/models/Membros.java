package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.interfaces.PostarMensagem;

public abstract class Membros implements PostarMensagem {
    private String assinaturaHorarioNormal;
    private String assinaturaHoraExtra;
    private String usuario;
    private String email;
    private Cargos cargos;

    public Membros(String usuario, Cargos cargos, String email, String assinaturaHorarioNormal, String assinaturaHoraExtra) {

        this.usuario = usuario;
        this.cargos = cargos;
        this.email = email;
        this.assinaturaHorarioNormal = assinaturaHorarioNormal;
        this.assinaturaHoraExtra = assinaturaHoraExtra;
    }

    public String getAssinaturaHorarioNormal() {
        return assinaturaHorarioNormal;
    }

    public String getAssinaturaHoraExtra() {
        return assinaturaHoraExtra;
    }

    public String getUsuario() {
        return usuario;
    }

    public Cargos getCargos() {
        return cargos;
    }
}
