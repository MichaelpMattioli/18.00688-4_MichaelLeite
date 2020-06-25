package br.maua.Model;

import br.maua.Interfaces.AutenticacaoDoUsuario;

public class Usuario implements AutenticacaoDoUsuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    void gerarPedido(){}

    void alterarPedido(){}

    @Override
    public boolean autenticacaoDoUsuario(String senha) {
        if(this.getSenha().equals(senha))
            return true;
        else
            return false;
    }
}
