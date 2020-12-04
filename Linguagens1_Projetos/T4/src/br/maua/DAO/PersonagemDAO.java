package br.maua.DAO;

import br.maua.enums.Equipamentos;
import br.maua.enums.Profissao;
import br.maua.enums.Raca;
import br.maua.models.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * Classe responsável pela implementação do DAO dos Personagens.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/12/2020
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
     * Método responsável por retornar um personagem específico.
     * @param condition Uma String relativa a codição que deve ser procurada na tabela do banco de dados.
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
                        result.getInt("nivel"),
                        Equipamentos.getEquipamento(result.getString("cabeca")),
                        Equipamentos.getEquipamento(result.getString("tronco")),
                        Equipamentos.getEquipamento(result.getString("pernas")),
                        Equipamentos.getEquipamento(result.getString("pes"))
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
     * Método para requisição de todas os personagens do banco de dados.
     * @return retorna uma lista de personagens com todos os personagens do banco de dados.
     */
    @Override
    public List<Personagem> getAll() {
        List<Personagem> personagems = new ArrayList<>();
        Profissao profissao = null;
        Raca raca = null;
        Equipamentos equipamentos = null;
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
                        result.getInt("nivel"),
                        Equipamentos.getEquipamento(result.getString("cabeca")),
                        Equipamentos.getEquipamento(result.getString("tronco")),
                        Equipamentos.getEquipamento(result.getString("pernas")),
                        Equipamentos.getEquipamento(result.getString("pes"))
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
     * Método para inserir um personagem no banco de dados.
     * @param personagem varivavel do tipo personagem que será o parâmetro para retirar os dados e inseri-lo no banco de dados.
     */
    @Override
    public void create(Personagem personagem) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca().getValor());
            preparedStatement.setString(3, personagem.getProfissao().getValor());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAd());
            preparedStatement.setInt(6, personagem.getAp());
            preparedStatement.setInt(7, personagem.getDef());
            preparedStatement.setInt(8, personagem.getDefM());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivel());
            preparedStatement.setString(13, personagem.getCabeca().toString());
            preparedStatement.setString(14, personagem.getTronco().toString());
            preparedStatement.setString(15, personagem.getPernas().toString());
            preparedStatement.setString(16, personagem.getPes().toString());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
            int statusErroCreate = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para atualização de um personagem do banco de dados, chave primária é o nome.
     * @param personagem varivavel do tipo personagem que será o parâmetro para atualizar os dados no banco de dados.
     */
    @Override
    public void update(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.setString(2, personagem.getRaca().getValor());
            preparedStatement.setString(3, personagem.getProfissao().getValor());
            preparedStatement.setInt(4, personagem.getMana());
            preparedStatement.setInt(5, personagem.getAd());
            preparedStatement.setInt(6, personagem.getAp());
            preparedStatement.setInt(7, personagem.getDef());
            preparedStatement.setInt(8, personagem.getDefM());
            preparedStatement.setInt(9, personagem.getVelocidade());
            preparedStatement.setInt(10, personagem.getDestreza());
            preparedStatement.setInt(11, personagem.getExperiencia());
            preparedStatement.setInt(12, personagem.getNivel());
            preparedStatement.setString(13, personagem.getCabeca().toString());
            preparedStatement.setString(14, personagem.getTronco().toString());
            preparedStatement.setString(15, personagem.getPernas().toString());
            preparedStatement.setString(16, personagem.getPes().toString());
            preparedStatement.setString(17, personagem.getNome());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Método para deletar um personagem no banco de dados.
     * @param personagem varivavel do tipo personagem que será o parâmetro para deletar o personagem no banco de dados.
     */
    @Override
    public void delete(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  Método que define o nome da tabela.
     * @return retorna o nome da tabela.
     */
    @Override
    public String getTableName() {
        return "personagem";
    }

    /**
     * Método que insere um dado especifico na tabela, comando relativo ao SQL.
     * @param table parametro que define qual a tabela a ser utilizada.
     * @return retorna uma String em formato para o SQL.
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel, cabeca, tronco, pernas, pes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    /**
     * Método que atualiza um dado específico da tabela, comando relativo ao SQL.
     * @param table parametro que define qual a tabela a ser utilizada.
     * @return retorna uma String em formato para o SQL.
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET nome = ?, raca = ?, profissao = ?, mana = ?, ad = ?, ap = ?, def = ?, defM = ?, velocidade = ?, destreza = ?, experiencia = ?, nivel = ?, cabeca = ?, tronco = ?, pernas = ?, pes = ? WHERE nome = ?;";
    }

    /**
     * Método que deleta um dado específico da tabela, comando relativo ao SQL.
     * @param table parametro que define qual a tabela a ser utilizada.
     * @return retorna uma String em formato para o SQL.
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE nome = ?";
    }

    /**
     * Método que recupera todos os dados da tabela, comando relativo ao SQL.
     * @param table parametro que define qual a tabela a ser utilizada.
     * @return retorna uma String em formato para o SQL.
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * Método que recupera um dado específico da tabela, comando relativo ao SQL.
     * @param table parametro que define qual a tabela a ser utilizada.
     * @return retorna uma String em formato para o SQL.
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}

