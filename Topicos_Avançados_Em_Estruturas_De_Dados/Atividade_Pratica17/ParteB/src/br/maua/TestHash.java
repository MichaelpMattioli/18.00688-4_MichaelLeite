package br.maua;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestHash {
    public static void main(String[] args) {
        int minimoValor = 0;
        int maximoValor = 19;
        int capacidadeKeys = (maximoValor - minimoValor + 1);
        int capacidadeHash = 10;

        ArrayList<Integer> tabKeys = vetorComValoresAleatorios(minimoValor,maximoValor);
        ArrayList<LinkedList> tabHash = new ArrayList(capacidadeHash);
        SList sList = new SList();

        int i,j;
        for (i = 0; i <= capacidadeHash-1; i++){
                LinkedList<Integer> listaSimplismenteLigada = sList.listaSimplismenteLigada();
                tabHash.add(listaSimplismenteLigada);
        }
        for (i = 0; i < capacidadeKeys; i++){
            tabHash.get(hash(tabKeys.get(i))).add(tabKeys.get(i));
        }
        for (i = 0; i <= capacidadeHash-1; i++){
            System.out.println("Hash = " + i +" -----> "+tabHash.get(i));
        }
    }

    public static ArrayList vetorComValoresAleatorios(int minimoValor, int maximoValor){
        int intervalo = (maximoValor - minimoValor + 1);
        int i;
        ArrayList<Integer> vetor = new ArrayList<>(intervalo);
        for ( i = 0; i < intervalo ; i++){
            vetor.add((int)(Math.random()*(intervalo) + minimoValor));
        }
        return vetor;

    }

    public static Integer hash(Integer key){
        return (key % 10);
    }
}
