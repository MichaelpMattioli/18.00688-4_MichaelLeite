package br.maua.compras;

import br.maua.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class SistemaCompras {

    private List<Produto> produtos;

    public SistemaCompras(){
        produtos = new ArrayList<>();
        produtos.add(new Produto(1,"Final Fantasy 7", 299.00));
        produtos.add(new Produto(1,"Zelda - BOTW", 299.00));
        produtos.add(new Produto(1,"Mario - Odyssey", 299.00));
        produtos.add(new Produto(1,"Animal Crossing", 399.00));
    }

    public void exibirListaProdutos(){
        System.out.println("Lista de Procutos Disponiveis");
        produtos.forEach((produto) -> System.out.println(produto));
    }

    public void run(){
        exibirListaProdutos();
    }
}
