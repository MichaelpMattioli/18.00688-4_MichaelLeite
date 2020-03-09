package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Usuario : ");
            String Usuario = ler.nextLine();

        System.out.println("Senha : ");
            String Senha = ler.nextLine();

        String testeUsuario = "", testeSenha = "";

        while (!(testeUsuario.equals(Usuario) && testeSenha.equals(Senha))) {

            System.out.println("Digite seu Usuario : ");
            testeUsuario = ler.nextLine();

            System.out.println("Digite sua Senha : ");
            testeSenha = ler.nextLine();

            if (!( testeUsuario.equals(Usuario) && testeSenha.equals(Senha) )){

                System.out.println("\nVoce digitou o usuario ou senha errado, digite novamente. ");
            }
        }
    }
}
