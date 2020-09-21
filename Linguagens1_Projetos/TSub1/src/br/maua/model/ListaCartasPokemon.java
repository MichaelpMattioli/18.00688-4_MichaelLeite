package br.maua.model;

import java.util.List;

public class ListaCartasPokemon {
    private List<CartasPokemon> pokemonList;
    private int pokemonAtual;

    public ListaCartasPokemon(List<CartasPokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.pokemonAtual = 0;
    }

    public final CartasPokemon getCartaAtual(){
        return pokemonList.get(pokemonAtual);
    }

    public boolean switchToPreviousCard(){
        if(pokemonAtual > 0){
            pokemonAtual--;
            return true;
        }
        return false;
    }

    public boolean switchToNextCard(){
        if(pokemonAtual < pokemonList.size() - 1){
            pokemonAtual++;
            return true;
        }
        return false;
    }

    public int getPokemonAtual() {
        return pokemonAtual;
    }
}
