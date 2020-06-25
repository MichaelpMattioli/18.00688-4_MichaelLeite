package br.maua.Interfaces;

/**
 * Interface responsavel por implementar o método de autenticação do usuario.
 * @author Michael Pedroza Mattioli Leite
 * @since 25/06/2020
 * @version 1.0
 */

public interface AutenticacaoDoUsuario {

    /**
     * Método de autenticação de usuario
     * @param senha Uma String que irá verificar se o as senhas de cada usuario sao iguais ao que
     *              ja foram cadastradas.
     * @return Um boolean
     */
    boolean autenticacaoDoUsuario(String senha);
}
