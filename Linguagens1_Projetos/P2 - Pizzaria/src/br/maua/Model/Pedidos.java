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

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public EstadoDoPedido getEstado() {
        return estado;
    }

    protected void setDescricao(String descricao) {
        Descricao = descricao;
    }

    protected void setEstado(EstadoDoPedido estado) {
        this.estado = estado;
    }

    protected void setValor(double valor) {
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

    public Pedidos criarPedido(){

        Scanner scanner = new Scanner(System.in);
        List<Pizzas> pizzasPedidas = new ArrayList<>();

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
                System.out.println(asPizzasPedidas + " Valor: " + valorDoPedido);
                System.out.println("----------------||----------------");
            }
                System.out.println("Escolha qual pizza voce deseja.");

                for (int i = 0; i < TiposDePizzas.values().length; i++) {
                    System.out.println(i + 1 + " - " + TiposDePizzas.values()[i]);
                }
                System.out.println("0 - Sair da escolha");


                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        pizzasPedidas.add(new Pizzas(TiposDePizzas.MARGUERITA));
                        break;
                    case 2:
                        pizzasPedidas.add(new Pizzas(TiposDePizzas.CALABRESA));
                        break;
                    case 3:
                        pizzasPedidas.add(new Pizzas(TiposDePizzas.PORTUGUESA));
                        break;
                    case 0:
                }
        }while (n != 0) ;

        Pedidos pedido = new Pedidos();
        pedido.setDescricao(asPizzasPedidas);
        pedido.setValor(valorDoPedido);

        return pedido;
    }

    public EstadoDoPedido mudarPedido(int Id){
        SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();
        EstadoDoPedido estadoDoPedido = null;
        for (Pedidos pedido: sistemaPrincipal.listaDosPedidos ) {
            if (pedido.getID().equals(Id)){
                if(pedido.getEstado().equals(EstadoDoPedido.REALIZADO))
                    pedido.setEstado(EstadoDoPedido.PREPARACAO);
                if(pedido.getEstado().equals(EstadoDoPedido.PREPARACAO))
                    pedido.setEstado(EstadoDoPedido.SAIU_PARA_ENTREGAR);
                if(pedido.getEstado().equals(EstadoDoPedido.SAIU_PARA_ENTREGAR))
                    pedido.setEstado(EstadoDoPedido.ENTREGUE);
                if(pedido.getEstado().equals(EstadoDoPedido.ENTREGUE))
                    pedido.setEstado(EstadoDoPedido.DEVOLVIDO);
                estadoDoPedido = pedido.getEstado();
            }
        }
        return estadoDoPedido;
    }


}
