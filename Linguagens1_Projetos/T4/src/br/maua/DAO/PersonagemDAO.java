package br.maua.DAO;

import br.maua.enums.Profissao;
import br.maua.enums.Raca;
import br.maua.models.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsável pela implementação do DAO dos Animes.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class PersonagemDAO implements DAO<Personagem>, DAOFields{
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:dados.db";
    private int statusErroCreate;

    /**
     * Conecta ao banco de dados.
     */
    public PersonagemDAO() {
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
    public List<Personagem> get(String condition){
        List<Personagem> personagems = new ArrayList<>();
        Profissao profissao = null;
        Raca raca = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Personagem personagem1 = new Personagem(
                        result.getString("nome"),
                        raca.getRaca(result.getString("raca")),
                        profissao.getProfissao(result.getString("profissao")),
                        result.getInt("mana"),
                        result.getInt("ad"),
                        result.getInt("ap"),
                        result.getInt("def"),
                        result.getInt("defM"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("experiencia"),
                        result.getInt("nivel")
                );
                personagems.add(personagem1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personagems;
    }

    /**
     * Função para requisição de todas os os animes.
     * @return retorna uma lista com todos os animes do banco de dados.
     */
    @Override
    public List<Personagem> getAll() {
        List<Personagem> personagems = new ArrayList<>();
        Profissao profissao = null;
        Raca raca = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Personagem personagem1 = new Personagem(
                        result.getString("nome"),
                        raca.getRaca(result.getString("raca")),
                        profissao.getProfissao(result.getString("profissao")),
                        result.getInt("mana"),
                        result.getInt("ad"),
                        result.getInt("ap"),
                        result.getInt("def"),
                        result.getInt("defM"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("experiencia"),
                        result.getInt("nivel")
                );
                personagems.add(personagem1);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personagems;
    }
    /**
     * Função para inserir um novo anime.
     * @param personagem Parametro para representar o novo anime a ser inserido.
     */
    @Override
    public void create(Personagem personagem) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca().toString());
            preparedStatement.setString(3, personagem.getProfissao().toString());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAd());
            preparedStatement.setInt(6, personagem.getAp());
            preparedStatement.setInt(7, personagem.getDef());
            preparedStatement.setInt(8, personagem.getDefM());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivel());
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
        return "Personagem";
    }

    /**
     * Função que insere um dado especifico na tabela, comando relativo ao SQL.
     * @param table parametro que define a tabela.
     * @return retorna InsertString em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
