package br.maua.models;

import br.maua.enums.Horarios;

import java.util.Scanner;

public class Sistema {
    String horaAtual = "REGULAR";

    public void Sistema(){
        ListaDeMembros listadeMembros = new ListaDeMembros();
        int escolha;
        do {
            MenuPrincipal(horaAtual);
            Scanner escolhar = new Scanner(System.in);
            escolha = escolhar.nextInt();
            switch (escolha){
                case 1:
                    listadeMembros.criarMembro();
                    break;
                case 2:
                    listadeMembros.mostrarListaDeMembros();

                    break;
                case 3:
                    listadeMembros.deletarUsuario();
                    break;
                case 4:
                    horaAtual = listadeMembros.mudarHorario(horaAtual);
                    break;
                case 5:
                    listadeMembros.postarMensagem(horaAtual);
                    break;
            }
        }while (escolha != 0);
    }
    public void MenuPrincipal(String hora) {
        System.out.println("\nBem vindo ao nosso sisteminha!\n");
        System.out.println("Escolha a opção:\n");
        System.out.println("1 - Cadastrar Novo Membro");
        System.out.println("2 - Membros Cadastrados");
        System.out.println("3 - Remover Usuario");
        System.out.println("4 - Mudança de horario");
        System.out.println("5 - Postar Mensagem");
        System.out.println("0 - Sair do Sistema");
        System.out.println("Jornada de Trabalho Atual: " + hora + "\n");
    }


}
