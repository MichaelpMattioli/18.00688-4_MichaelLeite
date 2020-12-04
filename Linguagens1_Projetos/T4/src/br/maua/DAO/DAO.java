package br.maua.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * * Interface responsável por implementar os métodos para interagir com o SQL.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/11/2020
 * @version 1.0
 * */

public interface DAO <T> {
    List<T> get(String condition);
    List<T> getAll();
    void update(T t) throws SQLException;
    void delete(T t);
    void create(T t) throws SQLException;
}

