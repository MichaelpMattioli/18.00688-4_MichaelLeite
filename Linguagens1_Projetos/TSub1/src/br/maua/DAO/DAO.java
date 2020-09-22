package br.maua.dao;

import java.sql.SQLException;
import java.util.List;
/**
 * * Interface responsavel pela representação do DAO que sera utilizado, são descritos o get, getALL, update, delete e create.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */
public interface DAO <T> {
    List<T> get(String condition);
    List<T> getAll();
    void update(T t) throws SQLException;
    void delete(T t);
    void create(T t) throws SQLException;
}

