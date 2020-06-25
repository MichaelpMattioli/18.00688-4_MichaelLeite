package br.maua.Model;

import br.maua.Enums.EstadoDoPedido;
import br.maua.Enums.FormaDePagamento;
import br.maua.Enums.TiposDePizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe responsavel por coordenar todos os pedidos relizados, alem de apresentar um apanhado geral de todo o sistema
 * como a criação de pedidos, modificação de pedidos, organização gráfica, contagem dos valores, formas de pagamento e estado do pedido.
 * @author Michael Pedroza Mattioli Leite
 * @since 25/06/2020
 * @version 1.0
 */

public class Pedidos {
    private String ID;
    private String Descricao;
    private double valor;
    private FormaDePagamento formaDePagamento;
    private EstadoDoPedido estado;

    /**
     * Construtor da classe pedidos, ela é responsavel por criar todas as caracterizar dessa classe
     * com os dados importantes para a sua manipulação.
     */

    public Pedidos() {
        this.ID = geradorId();
        this.Descricao = Descricao;
        this.valor = valor;
        this.formaDePagamento = FormaDePagamento.DINHEIRO;
        this.estado = EstadoDoPedido.REALIZADO;
    }

    public String getID() {
        return ID;
    }

    public String getDescricao() {
        return Descricao;
    }

    public double getValor() {
        return valor;
    }

    public EstadoDoPedido getEstado() {
        return estado;
    }

    private void setDescricao(String descricao) {
        Descricao = descricao;
    }

    private void setEstado(EstadoDoPedido estado) {
        this.estado = estado;
    }

    private void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método toString, amplamente utilizado para a manipulação das caracteristicas de cada pedido
     * através de uma interpretação gráfica da utilização das Strings.
     * @return Retorna todas as caracteristicas que compoem os pedidos: ID, descrição, valor, forma de pagamento e estado.
     */

    @Override
    public String toString() {
        return "Pedidos{" +
                "ID=" + ID +
                ", Descricao ='" + Descricao + '\'' +
                ", valor = " + valor +
                ", Forma de pagamento ='" + formaDePagamento + '\'' +
                ", estado = " + estado +
                '}';
    }

    /**
     * Método gerador de ID aleatório.
     * @return Uma String com um número aleatório.
     */

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }

    /**
     * Método que cria um pedido novo atráves da escolha do usuário. Por meio de uma lista, o usuario
     * escolhe quais pizzas ele irá vender e assim irá acrescentando em sua lista de venda, com a somatória
     * do valor e a lista de vendas logo abaixo da sua escolha.
     * @return Um pedido que apresenta todas os parâmetros que um pedido deve ter atualizado com a escolha do usuario.
     */

    protected Pedidos criarPedido(){

        Scanner scanner = new Scanner(System.in);
        List<Pizzas> pizzasPedidas = new ArrayList<>();
        Pedidos pedido = new Pedidos();
        Pizzas pizzas = null;

        int n = 0;
        double valorDoPedido = 0;
        int quantidadeAtual = 0;

        do {
            if (n != 0) {
                String pizzasNovasAux1 = "";
                valorDoPedido = 0;
                for (Pizzas pizzaPedida : pizzasPedidas) {                                         // Manipulação de String
                    valorDoPedido += pizzaPedida.getValor();                                       //
                    pizzasNovasAux1 += pizzaPedida;                                                //
                }                                                                                  //
                String temp[] = pizzasNovasAux1.split(" ");                                 //
                String pizzasNovasAux2 = "";                                                       //
                for ( int q = 0; q < TiposDePizzas.values().length; q++){                          //
                    int count = 0;                                                                 //
                    for (int i = 0; i < temp.length; i++) {                                        //
                        String comparacao = TiposDePizzas.values()[q]+"";                          //
                        if (comparacao.equals(temp[i]))                                            //
                            count++;                                                               //
                    }                                                                              //
                    if(count > 0)                                                                  //
                        pizzasNovasAux2 += " " + count + "x" + TiposDePizzas.values()[q] + " ";    //
                }                                                                                  //
                String pizzasNovas = pizzasNovasAux2.replaceAll("  ", "; ");    // Manipulação de String

                pedido.setValor(valorDoPedido);
                pedido.setDescricao(pizzasNovas);

                System.out.println("Pizzas:" + pizzasNovas + "|| Valor: " + valorDoPedido);
                System.out.println("----------------||----------------");
            }

            System.out.println("Escolha qual pizza voce deseja.");

            for (int i = 0; i < TiposDePizzas.values().length; i++) {
                System.out.println(i + 1 + " - " + TiposDePizzas.values()[i]);
            }
            System.out.println("0 - Sair da escolha");

            n = scanner.nextInt();
            if (n > 0 && n <= TiposDePizzas.values().length){
                pizzasPedidas.add(new Pizzas(TiposDePizzas.values()[n - 1]));
            }else if (n != 0)
                System.out.println("\n Numero digitado incorretamente \n");
        }while (n != 0) ;

        return pedido;
    }

    /**
     * Método que altera o estado do pedido, apatir de um estado inicial, no momento em que o usuario
     * realiza a mudança de estado, ele passa para o próximo.
     * @param Id String responsavel por identificar qual pedido irá mudar de estado.
     * @param listaPedidos Lista de pedidos que contem o pedido no qual quer mudar o estado.
     */

    public void mudarPedido(String Id, List<Pedidos> listaPedidos){
        for (Pedidos pedido: listaPedidos ) {
            if (pedido.getID().equals(Id)){
                if(pedido.getEstado().equals(EstadoDoPedido.REALIZADO))
                    pedido.setEstado(EstadoDoPedido.PREPARACAO);
                else if(pedido.getEstado().equals(EstadoDoPedido.PREPARACAO))
                    pedido.setEstado(EstadoDoPedido.SAIU_PARA_ENTREGAR);
                else if(pedido.getEstado().equals(EstadoDoPedido.SAIU_PARA_ENTREGAR))
                    pedido.setEstado(EstadoDoPedido.ENTREGUE);
                else
                    pedido.setEstado(EstadoDoPedido.DEVOLVIDO);
            }
        }
    }


}
