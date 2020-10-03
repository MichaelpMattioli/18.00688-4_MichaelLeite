package br.maua.dao;

import br.maua.models.Animes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsável pela implementação do DAO dos Animes.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class AnimesDAO implements DAO<Animes>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    private int statusErroCreate;


    /**
     * Conecta ao banco de dados.
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
     * @return retorno uma lista com um anime específico.
     */
    @Override
    public List<Animes> get(String condition){
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
     * @return retorna uma lista com todos os animes do banco de dados.
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
     * Função para inserir um novo anime.
     * @param animes Parametro para representar o novo anime a ser inserido.
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
     *  Função para pegar o nome da tabela.
     * @return retorna o nome da tabela.
     */
    @Override
    public String getTableName() {
        return "anime";
    }

    /**
     * Função que insere um dado especifico na tabela, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna InsertString em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, sinopse, quantidadeEpisodios, nota, urlPoster) VALUES (?, ?, ?, ?, ?);";
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
