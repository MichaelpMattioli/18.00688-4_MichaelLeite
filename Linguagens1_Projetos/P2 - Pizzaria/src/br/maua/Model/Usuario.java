package br.maua.Model;

import br.maua.Interfaces.AutenticacaoDoUsuario;

/**
 * Classe usuário, responsavel por limitar algumas operações, sendo elas a de alterar pedidos e a de criar pedidos.
 * Tal limitação se da pela autenticação do usuário, método que foi implementado nessa classe.
 * @author Michael Pedroza Mattioli Leite
 * @since 25/06/2020
 * @version 1.0
 */

public class Usuario implements AutenticacaoDoUsuario {
    private String nome;
    private String email;
    private String senha;

    /**
     * Construtor da classe usuario, contendo suas principais caracteristicas.
     * @param nome Uma String que representa o nome do usuario
     * @param email Uma String que representa o e-mail do usuario.
     * @param senha Uma String que representa a senha do usuario.
     */

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Getter do nome do usuario
     * @return retorna o nome do usuário.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Getter do email do usuario
     * @return retorna o e-mail do usuário.
     */

    public String getEmail() {
        return email;
    }

    /**
     * Getter da senha do usuario
     * @return Retorna a senha do usuário
     */

    private String getSenha() {
        return senha;
    }

    /**
     * Método implementado da interface que autentica a senha do usuário
     * @param senha Uma String que irá verificar se o as senhas de cada usuario sao iguais ao que
     *              ja foram cadastradas.
     * @return Retorna um boolean, caso a senha seja correta retorna true, caso a senha incorreta, retorna false.
     */

    @Override
    public boolean autenticacaoDoUsuario(String senha) {
        if(this.getSenha().equals(senha))
            return true;
        else
            return false;
    }
}
