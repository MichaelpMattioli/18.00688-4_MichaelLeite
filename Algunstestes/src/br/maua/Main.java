package br.maua;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double x =  9.42;
        double total = 0;
        ArrayList<Double> arrayList = new ArrayList();

        for ( int i = 1; i <= 60; i++){
            arrayList.add((x*i+50)*0.02*5.43);
        }

        for ( int i = 0; i < 60; i++){
            total = total + arrayList.get(i);
        }
        System.out.println(arrayList);
        System.out.println(total);
    }
}
