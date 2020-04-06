// Michael Pedroza Mattioli Leite   RA: 18.00688-4
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conta c1,c2,c3;
        Usuario u1,u2,u3;
        Transacoes t1;
        String qrCode;

        u1 = new Usuario("Michael", "123","1");
        u2 = new Usuario("Joao", "123","2");
        u3 = new Usuario("Maria", "123","3");

        c1 = new Conta(u1);
        c2 = new Conta(u2);
        c3 = new Conta(u3);

        t1 = new Transacoes();

        c1.setSaldo(1000);
        c2.setSaldo(250);
        c3.setSaldo(3000);

        System.out.println(c1.getUsuario().getNome());
        System.out.println(c2.getUsuario().getNome());
        System.out.println(c3.getUsuario().getNome());

        System.out.println(c1.getSaldo());
        System.out.println(c2.getSaldo());
        System.out.println(c3.getSaldo());

        qrCode = t1.qrCode(c1, 250);

        t1.pagar(c2,c1,qrCode);
        t1.pagar(c3,c1,qrCode);
        t1.pagar(c2,c1,qrCode);

        System.out.println(c1.getSaldo());
        System.out.println(c2.getSaldo());
        System.out.println(c3.getSaldo());

        qrCode = t1.qrCode(c2,1000);

        t1.pagar(c3,c1,qrCode);

        System.out.println(c1.getSaldo());
        System.out.println(c2.getSaldo());
        System.out.println(c3.getSaldo());

    }
}
