package com.company;
import com.sun.deploy.nativesandbox.NativeSandboxBroker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner ler = new Scanner(System.in);

	System.out.println("Digite seu R.A. : ");
        String RA = ler.nextLine();

	System.out.println("Digite seu nome completo : ");
        String nome = ler.nextLine();

    System.out.println("Digite seu telefone : ");
        String telefone = ler.nextLine();

    System.out.println("Digite seu email : ");
        String email = ler.nextLine();

    System.out.println("Digite sua idade : ");
        String idade = ler.nextLine();

    System.out.println("Nome : " + nome);
    System.out.println("R.A. : " + RA);
    System.out.println("Email : " + email);
    System.out.println("Telefone : " + telefone );
    System.out.println("Idade : " + idade + " anos.");

    }
}
