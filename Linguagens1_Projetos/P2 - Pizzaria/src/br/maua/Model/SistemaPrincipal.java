package br.maua.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPrincipal{
    List<Pedidos> listaDosPedidos = new ArrayList<>();

    private void Menu(){
        System.out.println("------------||------------");
        System.out.println("Pizzaria o Rato que Ri");
        System.out.println("1 - Nova venda");
        System.out.println("2 - Verificar pedidos");
        System.out.println("3 - Alterar pedidos");
        System.out.println("0 - Sair");
        System.out.print("------------||------------");
    }

    public void Sistema(){
        Usuario admin = new Usuario("Rato","pizzariadoratoqueri@gmail.com", "123456");
        Scanner scanner = new Scanner(System.in);
        Pedidos pedidos = new Pedidos();

        int escolha = 0;

        do {Menu();
            String senha = "0";
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite sua senha:");
                    senha = scanner.next();
                    if( admin.autenticacaoDoUsuario(senha )) {
                        pedidos = pedidos.criarPedido();
                        if(pedidos.getDescricao().equals("null") || pedidos.getDescricao().equals(""))
                            break;
                        else
                            listaDosPedidos.add(pedidos);}
                    break;
                case 2:
                    mostraPedidos(listaDosPedidos);
                    break;
                case 3:
                    System.out.println("Digite sua senha");
                    senha = scanner.next();
                    if( admin.autenticacaoDoUsuario(senha )) {
                        System.out.print("Informe o ID do pedido que queira alterar: ");
                        String iD = scanner.next();
                        pedidos.mudarPedido(iD,listaDosPedidos);}
                    break;
                case 0:
                    System.out.println("------------| Saiu do sistema |------------");
                    break;
            }
        }while (escolha != 0);
    }

    private void  mostraPedidos(List<Pedidos> listaDosPedidos){
        for (Pedidos pedido : listaDosPedidos) {
            System.out.println(pedido);
        }
    }
}
