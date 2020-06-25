package br.maua.Model;

import br.maua.Enums.EstadoDoPedido;
import br.maua.Enums.FormaDePagamento;
import br.maua.Enums.TiposDePizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pedidos {
    private String ID;
    private String Descricao;
    private double valor;
    private FormaDePagamento formaDePagamento;
    private EstadoDoPedido estado;

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

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }

    protected Pedidos criarPedido(){

        Scanner scanner = new Scanner(System.in);
        List<Pizzas> pizzasPedidas = new ArrayList<>();
        Pedidos pedido = new Pedidos();

        int n = 0;
        String asPizzasPedidas = "";
        double valorDoPedido = 0;

        do {
            if (n != 0) {
                String asPizzasPedidasAux1 = "";
                valorDoPedido = 0;
                for (Pizzas pizzaPedida : pizzasPedidas) {
                    asPizzasPedidasAux1 += "" + pizzaPedida;
                    valorDoPedido += pizzaPedida.getValor();
                }
                asPizzasPedidas = asPizzasPedidasAux1.replaceAll("  ", "; ");
                System.out.println("Pizzas:" + asPizzasPedidas + "|| Valor: " + valorDoPedido);
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

        pedido.setValor(valorDoPedido);
        pedido.setDescricao(asPizzasPedidas);

        return pedido;
    }

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
