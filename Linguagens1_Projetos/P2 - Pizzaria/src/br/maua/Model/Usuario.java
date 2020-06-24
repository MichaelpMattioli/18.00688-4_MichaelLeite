package br.maua.Model;

import br.maua.Interfaces.AutenticacaoDoUsuario;

import java.util.List;

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
    public List AutenticacaoDoUsuario(List<Usuario> listaDeUsuarios) {
        return null;
    }

}
