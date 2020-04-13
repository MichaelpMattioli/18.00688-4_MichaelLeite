package com.company;

import java.util.Arrays;

public class Mission {
    protected String[] missions = {"S;Proteger a Kiiubi.", "A;Investique a Akatsuki.", "B;Procure pistas sobre Orochimaru.", "C;Escolta: Protega os construtores da ponte.", "D;Resgate o Gatinho Mimi."};

    public void listAllMissions(String rankOfNinja){
        int i,j;
        String[] rank = rankOfNinja.split(";");

        for (i = 0; i < missions.length; i++){
            for (j = 0; j < rank.length; j++) {
                String missaoRankaux = "" + missions[i].charAt(0);
                if (missaoRankaux.equals(rank[j])) {
                    String[] missao = missions[i].split(";");
                    System.out.println("\tRank: " + missao[0] + " - " + missao[1]);
                }
            }
        }
    }
}
