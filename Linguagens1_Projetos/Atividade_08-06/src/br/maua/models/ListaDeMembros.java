package br.maua.models;

import br.maua.enums.Cargos;
import br.maua.enums.Horarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsavel por agrupar, criar, remover os membros em uma lista.
 * @author Gabriel de Laurentis Dias Cardoso e Michael Pedroza Mattioli Leite
 * @since 08/06/2020
 * @version 1.0
 */

public class ListaDeMembros {
    ArrayList<Membros> listaDeMembros = new ArrayList<>();

    protected void criarMembro(){
        String usuario,email;
        int i;
        System.out.println("Qual o nome?");
        Scanner scanner = new Scanner(System.in);
        usuario = scanner.nextLine();
        System.out.println("Qual o email?");
        email = scanner.nextLine();
        System.out.println("Qual cargo?");
        System.out.println("1-" + Cargos.BIG_BROTHERS);
        System.out.println("2-" + Cargos.MOBILE_MEMBERS);
        System.out.println("3-" + Cargos.HEAVY_LIFTERS);
        System.out.println("4-" + Cargos.SCRIPT_GUYS);
        i = scanner.nextInt();
        switch( i ){
            case 1:
                Membros bigBrothers = new BigBrothers(usuario, email);
                listaDeMembros.add(bigBrothers);
                break;
            case 2:
                Membros mobileMembers = new MobileMembers(usuario, email);
                listaDeMembros.add(mobileMembers);
                break;
            case 3:
                Membros heavyLifters = new HeavyLifters(usuario, email);
                listaDeMembros.add(heavyLifters);
                break;
            case 4:
                Membros scriptGuys = new ScriptGuys(usuario, email);
                listaDeMembros.add(scriptGuys);
                break;
        }
    }

    /**
     * Metodo que lista todos os membros.
     */

    protected void mostrarListaDeMembros(){
        for (Membros membro: listaDeMembros) {
            System.out.println(membro);
        }
    }

    /**
     * Metodo que remove os usuarios
     */
    protected void deletarUsuario(){
        System.out.println("Qual usuario deseja remover?");
        int i = 0;
        for (Membros membro: listaDeMembros) {
            System.out.println(i + " - " + membro.getUsuario());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int usuario = scanner.nextInt();
        listaDeMembros.remove(usuario);
    }

    /**
     * Metodos que faz a mudança de turno
     * @param horario turno que está no exato momento.
     * @return turno que irá entrar em vigor.
     */

    protected String mudarHorario(String horario){
        if(horario.equals(String.valueOf(Horarios.REGULAR)))
            return String.valueOf(Horarios.EXTRA);
        return String.valueOf(Horarios.REGULAR);
    }

    /**
     * Metodo que irá definir qual mensagem de um determinado membro será postada.
     * @param horario horario que está em vigor.
     */
    protected void postarMensagem(String horario){
        System.out.println("Qual usuario deseja falar?");
        int i = 0;
        for (Membros membro: listaDeMembros) {
            System.out.println(i + " - " + membro.getUsuario());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int usuario = scanner.nextInt();
        System.out.println(listaDeMembros.get(usuario).PostarMensagem(horario));
    }
}
