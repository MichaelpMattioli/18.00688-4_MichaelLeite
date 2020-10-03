package br.maua.dao;

import br.maua.models.Mangas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsável pela implementação do DAO dos Mangás.
 * @author Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class MangasDAO implements DAO<Mangas>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    private int statusErroCreate;


    /**
     * Conecta ao banco de dados.
     */
    public MangasDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param condition condição relativa a posição do indice na tabela.
     * @return retorno uma lista com um mangá específico.
     */
    @Override
    public List<Mangas> get(String condition) {
        List<Mangas> mangas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Mangas mangas1 = new Mangas(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantidadeCapitulos"),
                        result.getInt("quantidadeVolumes"),
                        result.getString("tipo"),
                        result.getFloat("nota"),
                        result.getString("urlPoster")
                );
                mangas.add(mangas1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mangas;
    }

    /**
     * Função para requisição de todos os mangás.
     * @return retorna uma lista com todos os mangás do banco de dados.
     */
    @Override
    public List<Mangas> getAll() {
        List<Mangas> mangas = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Mangas mangas1 = new Mangas(
                        result.getString("nome"),
                        result.getString("sinopse"),
                        result.getInt("quantidadeCapitulos"),
                        result.getInt("quantidadeVolumes"),
                        result.getString("tipo"),
                        result.getFloat("nota"),
                        result.getString("urlPoster")
                );
                mangas.add(mangas1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mangas;
    }

    /**
     * Função para atualização de um mangá específico no banco de dados.
     * @param mangas parametro que define qual mangá está sendo alterada.
     */
    @Override
    public void update(Mangas mangas){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, mangas.getNome());
            preparedStatement.setString(2, mangas.getSinopse());
            preparedStatement.setInt(3, mangas.getQuantidadeCapitulos());
            preparedStatement.setInt(4, mangas.getQuantidadeVolumes());
            preparedStatement.setFloat(5, mangas.getNota());
            preparedStatement.setString(6, mangas.getTipo());
            preparedStatement.setString(7, mangas.getUrlPoster());
            preparedStatement.setString(8, mangas.getNome());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para deletar um mangá da tabela.
     * @param mangas parametro que define qual mangá será deletada.
     */
    @Override
    public void delete(Mangas mangas) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, mangas.getNome());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Função para inserir um novo mangá.
     * @param mangas Parametro para representar o novo mangá a ser inserido.
     */
    @Override
    public void create(Mangas mangas) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, mangas.getNome());
            preparedStatement.setString(2, mangas.getSinopse());
            preparedStatement.setInt(3, mangas.getQuantidadeCapitulos());
            preparedStatement.setInt(4, mangas.getQuantidadeVolumes());
            preparedStatement.setFloat(5, mangas.getNota());
            preparedStatement.setString(6, mangas.getTipo());
            preparedStatement.setString(7, mangas.getUrlPoster());
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
        return "manga";
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
        return "UPDATE "+ table +" SET nome = ?, sinopse = ?, quantidadeCapitulos = ?, quantidadeVolumes = ?, tipo = ?, nota = ?, urlPoster = ? WHERE id = ?;";
    }

    /**
     * Função que insere um dado específico na tabela, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna InsertString em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, sinopse, quantidadeCapitulos, quantidadeVolumes, tipo, nota, urlPoster) VALUES (?, ?, ?, ?, ?, ?, ?);";
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
     * Função que recupera um dado específico do banco dados, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna SelectConditionalString em formato para o SQL.
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
