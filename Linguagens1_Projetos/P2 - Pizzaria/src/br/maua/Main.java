package br.maua;

import br.maua.Model.SistemaPrincipal;
import br.maua.Model.Usuario;

public class Main {

    public static void main(String[] args) {
        SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();
        sistemaPrincipal.Menu();

        Usuario usuario1 = new Usuario("Ronaldo","RonaldoBrilhaMuitoNoCurinthians@bol.com", "123456");
        System.out.println(usuario1.getEmail());
        System.out.println(usuario1.getNome());
        System.out.println(usuario1.getSenha());

    }
}
