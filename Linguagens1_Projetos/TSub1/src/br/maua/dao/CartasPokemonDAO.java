package br.maua.dao;

import br.maua.model.CartasPokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartasPokemonDAO implements DAO<CartasPokemon>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    public CartasPokemonDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
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
    @Override
    public List<CartasPokemon> getAll() {
        List<CartasPokemon> cartasPokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
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
    @Override
    public void update(CartasPokemon cartasPokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, cartasPokemon.getId());
            preparedStatement.setString(2, cartasPokemon.getNome());
            preparedStatement.setString(3, cartasPokemon.getRaridade());
            preparedStatement.setString(3, cartasPokemon.getSerie());
            preparedStatement.setString(3, cartasPokemon.getURL());
            preparedStatement.setString(4, cartasPokemon.getId());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
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
    @Override
    public void create(CartasPokemon cartasPokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, cartasPokemon.getId());
            preparedStatement.setString(2, cartasPokemon.getNome());
            preparedStatement.setString(3, cartasPokemon.getRaridade());
            preparedStatement.setString(3, cartasPokemon.getSerie());
            preparedStatement.setString(3, cartasPokemon.getURL());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String getTableName() {
        return "cartasPokemon";
    }
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?";
    }
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, nome = ?, raridade = ?, serie = ?, colecao = ?, URL = ? WHERE id = ?;";
    }
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (id, nome, raridade, serie, colecao, URL) VALUES (?, ?, ?, ?, ?, ?);";
    }
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
