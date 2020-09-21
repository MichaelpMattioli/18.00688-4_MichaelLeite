package br.maua.dao;

import br.maua.model.CartasPokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsavel pela implementação do DAO das CartasPokemon.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */

public class CartasPokemonDAO implements DAO<CartasPokemon>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    private int statusErroCreate;


    /**
     * Conecta ao Sql
     */
    public CartasPokemonDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param condition condição relativa a posição do indice na tabela.
     * @return retorno a carta requerida.
     */
    @Override
    public List<CartasPokemon> get(String condition) {
        List<CartasPokemon> cartasPokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                CartasPokemon cartasPokemon = new CartasPokemon(
                        result.getString("id"),
                        result.getString("name"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getString("URL")
                );
                cartasPokemons.add(cartasPokemon);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cartasPokemons;
    }

    /**
     * Função para requisição de todas as cartas.
     * @return retorna todas a cartas pokemon
     */
    @Override
    public List<CartasPokemon> getAll() {
        List<CartasPokemon> cartasPokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                CartasPokemon cartasPokemon = new CartasPokemon(
                        result.getString("id"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getString("URL")
                );
                cartasPokemons.add(cartasPokemon);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cartasPokemons;
    }

    /**
     * Função para atualização de uma carta especifica na lista.
     * @param cartasPokemon parametro que define qual carta está sendo alterada.
     */
    @Override
    public void update(CartasPokemon cartasPokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, cartasPokemon.getId());
            preparedStatement.setString(2, cartasPokemon.getNome());
            preparedStatement.setString(3, cartasPokemon.getRaridade());
            preparedStatement.setString(4, cartasPokemon.getSerie());
            preparedStatement.setString(5, cartasPokemon.getColecao());
            preparedStatement.setString(6, cartasPokemon.getURL());
            preparedStatement.setString(7, cartasPokemon.getId());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para deletar cartas da lista
     * @param cartasPokemon parametro que define qual carta será deletada.
     */
    @Override
    public void delete(CartasPokemon cartasPokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, cartasPokemon.getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para inserir um nova carta
     * @param cartasPokemon Parametro para representar a nova carta a ser inserida
     * @throws SQLException
     */
    @Override
    public void create(CartasPokemon cartasPokemon) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
        preparedStatement.setString(1, cartasPokemon.getId());
        preparedStatement.setString(2, cartasPokemon.getNome());
        preparedStatement.setString(3, cartasPokemon.getRaridade());
        preparedStatement.setString(4, cartasPokemon.getSerie());
        preparedStatement.setString(5, cartasPokemon.getColecao());
        preparedStatement.setString(6, cartasPokemon.getURL());
        //Executa o PreparedStatement
        int retorno = preparedStatement.executeUpdate();
        int statusErroCreate = 0;
    }

    /**
     *  Função para pegar o nome da tabela
     * @return retorna o nome da tabela
     */
    @Override
    public String getTableName() {
        return "cartasPokemon";
    }

    /**
     * função para pega uma DeleteString, relativa ao SQL.
     * @param table parametro que define a tabela.
     * @return retorno DeleteString em formato para o SQL.
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }

    /**
     * Função para pegar UpdateString no formato do SQL.
     * @param table parametro que define a tabela.
     * @return retorna UpdateString em formato para o SQL.
      */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, nome = ?, raridade = ?, serie = ?, colecao = ?, URL = ? WHERE id = ?;";
    }

    /**
     * Função para pegar InsertString no formato do SQL.
     * @param table parametro que define a tabela.
     * @return retorna InsertString em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (id, nome, raridade, serie, colecao, URL) VALUES (?, ?, ?, ?, ?, ?);";
    }

    /**
     * Função para pegar SelectAllString no formato do SQL.
     * @param table parametro que define a tabela.
     * @return retorna SelectAllString em formato para o SQL.
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * Função para pegar o SelectConditionalString no formato do SQL.
     * @param table parametro que define a tabela.
     * @return retorna SelectConditionalString em formato para o SQL.
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
