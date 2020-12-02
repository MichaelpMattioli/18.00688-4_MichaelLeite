package br.maua.DAO;

public interface DAOFields {
    String getTableName();

    String getInsertString(String table);

    String getSelectAllString(String table);

    String getSelectConditionalString(String table);
}