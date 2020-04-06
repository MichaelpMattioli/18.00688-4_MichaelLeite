package com.company;

public class MinhaClasse {
    private static int contaObjetos = 0; // o static torna comum para todas as instencias.

    public MinhaClasse(){
        MinhaClasse.contaObjetos += 1;
    }

    public static int getContaObjetos(){
        return MinhaClasse.contaObjetos;
    }
}
