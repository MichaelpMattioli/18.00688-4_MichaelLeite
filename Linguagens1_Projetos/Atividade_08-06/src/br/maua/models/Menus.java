package br.maua.models;

import java.util.Scanner;

public class Menus {
    public void Sistema(){
        ListaDeMembros listadeMembros = new ListaDeMembros();
        int escolha;
        do {
            MenuPrincipal();
            Scanner escolhar = new Scanner(System.in);
            escolha = escolhar.nextInt();
            switch (escolha){
                case 1:
                    listadeMembros.criarMembro();
                    break;
                case 2:
                    listadeMembros.criarMembro();
                    break;
                case 3:
                    listadeMembros.criarMembro();
                    break;
                case 4:
                    listadeMembros.criarMembro();
                    break;
                case 5:
                    listadeMembros.criarMembro();
                    break;
            }
        }while (escolha != 0)
    }
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


}
