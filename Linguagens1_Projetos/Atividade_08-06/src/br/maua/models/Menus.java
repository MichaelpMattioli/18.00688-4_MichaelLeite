package br.maua.models;

import java.util.Scanner;

public class Menus {
    public void MenuPrincipal() {
        System.out.println("Bem vindo ao nosso sisteminha!\n");
        System.out.println("Escolha a opção:\n");
        System.out.println("1 - Cadastrar Novo Membro");
        System.out.println("2 - Membros Cadastrados");
        System.out.println("3 - Remover Usuario");
        System.out.println("4 - Mudança de horario");
        System.out.println("5 - Postar Mensagem");
        System.out.println("0 - Sair do Sistema\n");
    }

    private void escolha(){
        MenuPrincipal();
        Scanner msg = new Scanner(System.in);
        int x = msg.nextInt();
        switch (x){
            case(1):
        }

    }
}
