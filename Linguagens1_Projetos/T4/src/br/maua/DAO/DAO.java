package br.maua.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T> {
    List<T> get(String condition);
    List<T> getAll();
    void update(T t) throws SQLException;
    void delete(T t);
    void create(T t) throws SQLException;
}

