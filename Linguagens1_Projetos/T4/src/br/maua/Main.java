package br.maua;

import br.maua.aplicacoes.AplicacaoDAO;

public class Main {

    public static void main(String[] args) {
        AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
        aplicacaoDAO.run();
    }
}
