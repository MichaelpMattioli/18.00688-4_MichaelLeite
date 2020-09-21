package br.maua.dao;
/**
 * * Interface responsavel pela criação dos DAOFields, nela são descritos getTableName, getDeleteString, getUpdateString, getInsertString, getSelectAllString e getSelectConditionalString.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
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
