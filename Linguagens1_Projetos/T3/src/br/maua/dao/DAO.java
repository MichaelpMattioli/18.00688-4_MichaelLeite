package br.maua.dao;

import java.util.List;
/**
 * * Interface responsável pela representação do DAO que sera utilizado, são descritos o get, getALL e create.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */
public interface DAO <T> {
    List<T> get(String condition);
    List<T> getAll();
    void create(T t);
}
