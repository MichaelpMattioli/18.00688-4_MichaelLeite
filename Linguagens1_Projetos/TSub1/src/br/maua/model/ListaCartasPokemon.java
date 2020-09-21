package br.maua.model;

import java.util.List;

/**
 * * Classe responsavel pela lista de cartas pokemon e pelas funções ligadas a ela.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */

public class ListaCartasPokemon {
    private List<CartasPokemon> pokemonList;
    private int pokemonAtual;

    /**
     * Método responsavel por criar o construtor da classe
     * @param pokemonList lista de cartasPokemon
     */
    public ListaCartasPokemon(List<CartasPokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.pokemonAtual = 0;
    }

    /**
     * Método que retorna a carta que está no indice atual da lista
     * @return CartasPokemon da lista de cartasPokemon
     */

    public final CartasPokemon getCartaAtual(){
        return pokemonList.get(pokemonAtual);
    }

    /**
     * Método que diminui o indice atual da lista de cartasPokemon, para assim mudar entre as cartas da lista
     */

    public boolean switchToPreviousCard(){
        if(pokemonAtual > 0){
            pokemonAtual--;
            return true;
        }
        return false;
    }

    /**
     * Método que aumenta o indice atual da lista de cartasPokemon, para assim mudar entre as cartas da lista
     */

    public boolean switchToNextCard(){
        if(pokemonAtual < pokemonList.size() - 1){
            pokemonAtual++;
            return true;
        }
        return false;
    }

    /**
     * Get o indice atual da lista que está atualizado na classe.
     * @return Um Integer
     */

    public int getPokemonAtual() {
        return pokemonAtual;
    }

    /**
     * Setter que muda para o indice do pokemon atual em que se deseja.
     * @param pokemonAtual
     */

    public void setPokemonAtual(int pokemonAtual) {
        if(0 <= pokemonAtual && pokemonAtual < pokemonList.size() - 1 )
            this.pokemonAtual = pokemonAtual;
    }
}
