package br.maua.dao;

import br.maua.models.Animes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsável pela implementação do DAO dos Animes.
 * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class AnimesDAO implements DAO<Animes>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    private int statusErroCreate;


    /**
     * Conecta ao Sql
     */
    public AnimesDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param condition condição relativa a posição do indice na tabela.
     * @return retorno um anime especifico.
     */
    @Override
    public List<Animes> get(String condition) {
        List<Animes> animes = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Animes animes1 = new Animes(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantidadeEpisodios"),
                        result.getFloat("nota"),
                        result.getString("urlPoster")
                );
                animes.add(animes1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return animes;
    }

    /**
     * Função para requisição de todas os os animes.
     * @return retorna todas os animes do banco de dados
     */
    @Override
    public List<Animes> getAll() {
        List<Animes> animes = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Animes animes1 = new Animes(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantidadeEpisodios"),
                        result.getFloat("nota"),
                        result.getString("urlPoster")
                );
                animes.add(animes1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return animes;
    }

    /**
     * Função para atualização de uma carta especifica na lista.
     * @param animes parametro que define qual anime está sendo alterada.
     */
    @Override
    public void update(Animes animes){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, animes.getNome());
            preparedStatement.setString(2, animes.getSinopse());
            preparedStatement.setInt(3, animes.getQuantidadeEpisodios());
            preparedStatement.setFloat(4, animes.getNota());
            preparedStatement.setString(5, animes.getUrlPoster());
            preparedStatement.setString(6, animes.getNome());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para deletar anime da tabela
     * @param animes parametro que define qual anime será deletada.
     */
    @Override
    public void delete(Animes animes) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, animes.getNome());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para inserir um novo anime
     * @param animes Parametro para representar o novo anime a ser inserida
     */
    @Override
    public void create(Animes animes) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, animes.getNome());
            preparedStatement.setString(2, animes.getSinopse());
            preparedStatement.setInt(3, animes.getQuantidadeEpisodios());
            preparedStatement.setFloat(4, animes.getNota());
            preparedStatement.setString(5, animes.getUrlPoster());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
            int statusErroCreate = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     *  Função para pegar o nome da tabela
     * @return retorna o nome da tabela
     */
    @Override
    public String getTableName() {
        return "anime";
    }

    /**
     * Função que deleta um dado da tabela, relativo ao comando do SQL.
     * @param table parametro que define a tabela.
     * @return retorno DeleteString em formato para o SQL.
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE nome = ?";
    }

    /**
     * Função que atualiza um dado da tabela dentro do banco de dados, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna UpdateString em formato para o SQL.
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, nome = ?, raridade = ?, serie = ?, colecao = ?, URL = ? WHERE id = ?;";
    }

    /**
     * Função que insere um dado especifico na tabela, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna InsertString em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (id, nome, raridade, serie, colecao, URL) VALUES (?, ?, ?, ?, ?, ?);";
    }

    /**
     * Função que recupera todos os dados do banco dados, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna SelectAllString em formato para o SQL.
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * Função que recupera um dado especifico do banco dados, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna SelectConditionalString em formato para o SQL.
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
