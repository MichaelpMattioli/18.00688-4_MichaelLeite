package br.maua.Model;

import br.maua.Enums.EstadoDoPedido;
import br.maua.Enums.FormaDePagamento;
import br.maua.Enums.TiposDePizzas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pedidos {
    private String ID;
    private TiposDePizzas Descricao;
    private double valor;
    private FormaDePagamento formaDePagamento;
    private EstadoDoPedido estado;

    ArrayList<Pedidos> listaDePedidos = new ArrayList<>();

    public Pedidos(TiposDePizzas descricao, double valor, FormaDePagamento pagamento) {
        this.ID = geradorId();
        this.Descricao = descricao;
        this.valor = valor;
        this.formaDePagamento = pagamento;
        this.estado = EstadoDoPedido.REALIZADO;
    }

    public Pedidos() {
        this.ID = geradorId();
        this.Descricao = Descricao;
        this.valor = valor;
        this.formaDePagamento = getFormaDePagamento();
        this.estado = EstadoDoPedido.REALIZADO;
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

    public String getID() {
        return ID;
    }

    public TiposDePizzas getDescricao() {
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

    public void setEstado(EstadoDoPedido estado) {
        this.estado = estado;
    }

    private String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }

    void criarPedido(){
        int i;
        Scanner scanner = new Scanner(System.in);
        Pizzas pizzas = new Pizzas();
        System.out.println("Escolha qual pizza voce deseja.");
        pizzas.listaDePizzas();
        i = scanner.nextInt();
        switch( i ){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    protected void mostrarPedidos(){
        for (Pedidos pedido: listaDePedidos) {
            System.out.println(pedido);
        }
    }
}
