package br.maua.teste;

import br.maua.dao.CartasPokemonDAO;
import br.maua.model.CartasPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoDAO {
    private List<CartasPokemon> cartasPokemons;
    private CartasPokemonDAO cartasPokemonDAO;
    private Scanner scanner;

    public AplicacaoDAO() {
        cartasPokemons = new ArrayList<>();
        cartasPokemonDAO = new CartasPokemonDAO();
        scanner = new Scanner(System.in);
    }

    public void run(){
        boolean alive = true;
        do{
            menu();
            int opcao = Integer.parseInt(scanner.next());
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    exibirProdutos();
                    break;
                case 2:
                    deletarProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    cadastrarNovoProduto();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void cadastrarNovoProduto(){
        String id,nome,raridade,serie,colecao,URL;
        System.out.println("Informe os dados:");
        id = scanner.nextLine();
        nome = scanner.nextLine();
        raridade = scanner.nextLine();
        serie = scanner.nextLine();
        colecao = scanner.nextLine();
        URL = scanner.nextLine();
        cartasPokemonDAO.create(new CartasPokemon(
                id, nome, raridade, serie, colecao, URL
        ));
    }

    private void atualizarProduto() {
        cartasPokemons = cartasPokemonDAO.getAll();
        System.out.println("ID da carta para Atualizar:");
        String id = scanner.nextLine();
        System.out.println("Cadastre os novos valores:");
        String nome,raridade,serie,colecao,URL;
        System.out.println("Informe os dados:");
        nome = scanner.nextLine();
        raridade = scanner.nextLine();
        serie = scanner.nextLine();
        colecao = scanner.nextLine();
        URL = scanner.nextLine();
        cartasPokemonDAO.update(new CartasPokemon(
                id, nome, raridade, serie, colecao, URL
        ));
    }

    private void deletarProduto(){
        System.out.println("ID da carta:");
        String id = scanner.nextLine();
        CartasPokemon cartasPokemon = new CartasPokemon(id);
        cartasPokemonDAO.delete(cartasPokemon);
    }

    private void exibirProdutos() {
        cartasPokemons = cartasPokemonDAO.getAll();
        System.out.println("Cartas:");
        cartasPokemons.forEach( cartasPokemon -> System.out.println(cartasPokemon));
    }

    private void menu() {
        System.out.println("Pokedex");
        System.out.println("1 - Cartas Cadastradas");
        System.out.println("2 - Deletar Carta");
        System.out.println("3 - Alterar Carta");
        System.out.println("4 - Cadastrar Carta");
        System.out.println("0 - Sair");
    }
}
