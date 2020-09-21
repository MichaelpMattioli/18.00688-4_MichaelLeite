package br.maua;

import br.maua.teste.AplicacaoDAO;

public class testemainbackend {
    public static void main(String[] args) {
        AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
        aplicacaoDAO.run();
    }
}
