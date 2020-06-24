package br.maua.Model;

import br.maua.Enums.EstadoDoPedido;

import java.util.Random;

public class Pedidos<Static> {
    static private String ID = geradorId();
    private String Descricao;
    private double valor;
    private String formaDePagamento;
    private EstadoDoPedido estado;

    public Pedidos(String formaDePagamento, String estado) {
        this.formaDePagamento = formaDePagamento;
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

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public EstadoDoPedido getEstado() {
        return estado;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
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

    private static String geradorId(){
        Random random = new Random();
        String idGerado = "";
        for(int i = 0; i < 3; i++)
            idGerado += random.nextInt(10);
        return idGerado;
    }
}
