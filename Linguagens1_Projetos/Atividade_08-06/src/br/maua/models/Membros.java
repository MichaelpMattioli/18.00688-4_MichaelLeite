package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.interfaces.PostarMensagem;

/**
 * Classe abstrata que define as caracteristicas de todos os membros do grupo.
 * @author Gabriel de Laurentis Dias Cardoso & Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public abstract class Membros implements PostarMensagem {
    private String assinaturaHorarioNormal;
    private String assinaturaHoraExtra;
    private String usuario;
    private String email;
    private Cargos cargos;

    /**
     * Construtor da classe Membros.
     * @param usuario Usuario do membro.
     * @param cargos Email do membro.
     * @param email Email do membro.
     * @param assinaturaHorarioNormal Email do membro.
     * @param assinaturaHoraExtra Email do membro.
     */

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

    @Override
    public String toString() {
        return "Membros{" +
                " usuario='" + usuario + '\'' +
                ", email='" + email + '\'' +
                ", cargo=" + cargos +
                '}';
    }
}
