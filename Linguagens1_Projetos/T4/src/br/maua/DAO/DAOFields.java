package br.maua.DAO;

/**
 * * Interface responsável por implementar os métodos para interagir com o SQL.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/11/2020
 * @version 1.0
 * */

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}