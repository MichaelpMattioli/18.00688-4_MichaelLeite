// Michael Pedroza Mattioli Leite   RA: 18.00688-4
package com.company;

import java.util.Random;


public class Transacoes {

    public void pagar (Conta contaRemetente,Conta contaDestino, String qrCode){
        String[] dados = qrCode.split(";");

        if ( contaDestino.getIdConta() == Integer.parseInt(dados[0])){
            if ( contaRemetente.sacar(Double.parseDouble(dados[2])))
                contaDestino.setSaldo(contaDestino.getSaldo() + Double.parseDouble(dados[2]));
            else
                System.out.println("Transacao nao realizada");
        }
        else
            System.out.println("Transacao nao realizada");
    }

    public int numeroAleatorio(){
        Random r = new Random();
        return r.nextInt(10000);
    }

    public String qrCode (Conta contaQueRecebe,double valor){
        String ID = "" + contaQueRecebe.getIdConta();
        String usuario = "" + contaQueRecebe.getUsuario().getNome();
        String pagamento = ""+ valor;
        String numAleatorio = "" + numeroAleatorio();

        String qrCode = ID + ";" + usuario + ";" + pagamento  + ";" + numAleatorio;
        return qrCode;
    }
}
