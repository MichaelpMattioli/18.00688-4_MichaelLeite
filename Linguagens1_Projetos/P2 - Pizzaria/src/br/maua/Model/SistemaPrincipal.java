package br.maua.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPrincipal{

    public void Menu(){
        System.out.println("Pizzaria o Rato que Ri");
        System.out.println("1 - Nova venda");
        System.out.println("2 - Verificar pedidos");
        System.out.println("3 - Alterar pedidos");
        System.out.println("0 - Sair");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void Sistema(){
        Pedidos pedidos = new Pedidos();
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                pedidos.criarPedido();
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                System.out.println("------------| Saiu do sistema |------------");
                break;
        }
    }while (escolha != 0);
}


}
