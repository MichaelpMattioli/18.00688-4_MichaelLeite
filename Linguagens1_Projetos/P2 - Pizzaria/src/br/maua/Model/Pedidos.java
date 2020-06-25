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

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public void setEstado(EstadoDoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "ID=" + ID +
                ", Descricao='" + Descricao + '\'' +
                ", valor=" + valor +
                ", formaDePagamento='" + formaDePagamento + '\'' +
                ", estado=" + estado +
                '}';
    }

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }

    public void criarPedido(){

        Scanner scanner = new Scanner(System.in);
        List<Pizzas> pizzasPedidas = new ArrayList<>();

        int n = 0;
        String asPizzasPedidas = "";
        double valorDoPedido = 0;
        do {
            if (n != 0) {
                String asPizzasPedidasAux1 = "";
                for (Pizzas pizzaPedida : pizzasPedidas) {
                    asPizzasPedidasAux1 += "" + pizzaPedida;
                    valorDoPedido += pizzaPedida.getValor();
                }
                String asPizzasPedidasAux2= asPizzasPedidasAux1.replaceAll("  ", "; ");
                asPizzasPedidas = "[" + asPizzasPedidasAux2 + "]";
                System.out.println(asPizzasPedidas);
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



    }


}
