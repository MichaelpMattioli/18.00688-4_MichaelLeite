package br.maua;

import br.maua.testes.Aplicacao;
import br.maua.testes.AplicacaoDAO;

public class Main {

    public static void main(String[] args) {
        AplicacaoDAO app = new AplicacaoDAO();
        app.run();
    }
}
