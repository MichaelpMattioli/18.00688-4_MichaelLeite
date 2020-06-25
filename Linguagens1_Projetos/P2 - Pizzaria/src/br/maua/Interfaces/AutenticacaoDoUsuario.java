package br.maua.Interfaces;

import br.maua.Model.Usuario;

import java.util.List;

public interface AutenticacaoDoUsuario {
    boolean autenticacaoDoUsuario(Usuario user, String senha);
}
