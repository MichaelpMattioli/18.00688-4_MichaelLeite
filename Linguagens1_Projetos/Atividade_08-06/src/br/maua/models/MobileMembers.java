package br.maua.models;

import br.maua.enums.Cargos;

public class MobileMembers extends Membros{
    private String assinaturaHorarioNormal = "HappyCoding!";
    private String assinaturaHoraExtra = "Happy_C0d1ng. Maskers";

    public MobileMembers(String usuario, Cargos cargos) {
        super(usuario, cargos);
    }

    @Override
    public String PostarMensagem(String mensagem) {

        return null;
    }
}
