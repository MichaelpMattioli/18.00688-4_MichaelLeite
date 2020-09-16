package br.maua.implementacoes.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TesteLeitura {
    public static void main(String[] args) {
        File file = new File("nome.txt");
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().forEach(linha -> System.out.println("Linha lida:"+ linha));

            bufferedReader.close();
            fileReader.close();

        }catch(Exception exception){
            System.out.println("Algo deu errado");
            exception.printStackTrace();
        }
    }
}
