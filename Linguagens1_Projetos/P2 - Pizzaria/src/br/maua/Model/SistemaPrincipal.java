package br.maua.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPrincipal{

    /**
     * Menu do sistema, por ele é possivel visualizar como o sistema funciona através de entradas numéricas.
     */

    private void Menu(){
        System.out.println("------------||------------");
        System.out.println("Pizzaria o Rato que Ri");
        System.out.println("1 - Nova venda");
        System.out.println("2 - Verificar pedidos");
        System.out.println("3 - Alterar pedidos");
        System.out.println("0 - Sair");
        System.out.print("------------||------------");
    }

    /**
     * Método responsavel por interligar as demais classes, assim criando as instancia dos objetos,
     * e é por meio dela, a aplicação é executada.
     * Ela é responsavel também por criar algumas interações graficas para melhor visualização do usuario com o
     * programa.
     */

    public void Sistema() {
        Usuario admin = new Usuario("Rato", "pizzariadoratoqueri@gmail.com", "123456");
        Scanner scanner = new Scanner(System.in);
        Pedidos pedidos = new Pedidos();
        List<Pedidos> listaDosPedidos = new ArrayList<>();

        int escolha = 0;

        do {
            Menu();
            String senha = "0";
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite sua senha: ");
                    senha = scanner.next();
                    if (admin.autenticacaoDoUsuario(senha)) {
                        pedidos = pedidos.criarPedido();
                        if (pedidos.getDescricao().equals("null") || pedidos.getDescricao().equals(""))
                            break;
                        else
                            listaDosPedidos.add(pedidos);
                    }
                    break;
                case 2:
                    for (Pedidos pedido : listaDosPedidos)
                        System.out.println(pedido);
                    break;
                case 3:
                    System.out.print("Digite sua senha: ");
                    senha = scanner.next();
                    if (admin.autenticacaoDoUsuario(senha)) {
                        System.out.print("Informe o ID do pedido que queira alterar: ");
                        String iD = scanner.next();
                        pedidos.mudarPedido(iD, listaDosPedidos);
                    }
                    break;
                case 0:
                    System.out.println("------------| Saiu do sistema |------------");
                    break;

            }
        } while (escolha != 0) ;

    }

}
