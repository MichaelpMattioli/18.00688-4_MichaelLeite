package br.maua.projeto.teste;

import br.maua.projeto.model.Jogo;
import br.maua.projeto.model.ListaDeJogos;

public class TesteListaDeJogos {
    public static void main(String[] args) {
        ListaDeJogos jogos = new ListaDeJogos();

        System.out.println("Lista Atual: " + jogos);

        Jogo jogo1 = new Jogo("PC", "LoL");
        Jogo jogo2 = new Jogo("PC", "Diablo");
        Jogo jogo3 = new Jogo("PC", "Halo");

        jogos.addJogo(jogo1);
        jogos.addJogo(jogo2);
        jogos.addJogo(jogo3);
    }
}
