package br.maua.Model;

import br.maua.Enums.EstadoDoPedido;

public class Pedidos {
    private int ID;
    private String Descricao;
    private double valor;
    private String formaDePagamento;
    private EstadoDoPedido estado;

    public Pedidos(int ID, String descricao, double valor, String formaDePagamento, String estado) {
        this.ID = ID;
        Descricao = descricao;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        this.estado = EstadoDoPedido.REALIZADO;
    }

    public int getID() {
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
}
