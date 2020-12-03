package br.maua.aplicacoes;

import br.maua.DAO.PersonagemDAO;
import br.maua.enums.Profissao;
import br.maua.enums.Raca;
import br.maua.models.Personagem;

import java.util.List;
import java.util.Scanner;

public class AplicacaoDAO {
    private List<Personagem> personagemList;

    private PersonagemDAO personagemDAO = new PersonagemDAO();

    private Scanner scanner = new Scanner(System.in);

    public void run(){
        boolean alive = true;
        do{
            menu();
            int opcao = Integer.parseInt(scanner.next());
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    System.out.print("Personagens: ");
                    exibirPersonagens();
                    break;
                case 2:
                    System.out.print("Criação de personagem: ");
                    cadastrarPersonagem();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void menu() {
        System.out.println("Data Base Animes e Mangas");

        System.out.println("1 - Consultar personagens");
        System.out.println("2 - Cadastra personagem");
        System.out.println("0 - Sair");
    }

    private void exibirPersonagens() {
        personagemList = personagemDAO.getAll();
        System.out.println("Animes:");
        personagemList.forEach( personagem -> System.out.println(personagem));
    }

    private void cadastrarPersonagem(){
        try {
            System.out.println("Informe o ");
            System.out.println("nome:");
            String nome = scanner.next();
            System.out.println("raça:");
            Raca raca = escolhaRaca();
            System.out.println("profissao:");
            Profissao profissao = escolhaProfissao();
            System.out.println("mana:");
            Integer mana = scanner.nextInt();
            System.out.println("ad:");
            Integer ad = scanner.nextInt();
            System.out.println("ap:");
            Integer ap = scanner.nextInt();
            System.out.println("def:");
            Integer def = scanner.nextInt();
            System.out.println("defM:");
            Integer defM = scanner.nextInt();
            System.out.println("velocidade:");
            Integer velocidade = scanner.nextInt();
            System.out.println("destreza:");
            Integer destreza = scanner.nextInt();
            System.out.println("experiencia:");
            Integer experiencia = scanner.nextInt();
            System.out.println("nivel:");
            Integer nivel = scanner.nextInt();

            Personagem personagem = new Personagem(
                    nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel
            );

            System.out.println(personagem);

            personagemDAO.create(personagem);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algum erro ocorreu no cadastramento");
        }
    }

    private Raca escolhaRaca() {
        Raca racaEscolhida = null;

        System.out.println("Escolha sua raça: ");
        int i = 0;
        for (Raca raca: Raca.values()) {
            i++;
            System.out.println(i + " - " + raca.getValor());
        }
        int escolha = scanner.nextInt();

        int j =0;
        for (Raca raca: Raca.values()) {
            j++;
            if(escolha == j){
                racaEscolhida = raca;
            }
        }

        System.out.println("Voce escolheu a raça: " + racaEscolhida.getValor());
        return racaEscolhida;
    }

    private Profissao escolhaProfissao() {
        Profissao profissaoEscolhida = null;

        System.out.println("Escolha sua profissao: ");
        int i = 0;
        for (Profissao profissao: Profissao.values()) {
            i++;
            System.out.println(i + " - " + profissao.getValor());
        }
        int escolha = scanner.nextInt();

        int j =0;
        for (Profissao profissao: Profissao.values()) {
            j++;
            if(escolha == j){
                profissaoEscolhida = profissao;
            }
        }

        System.out.println("Voce escolheu a profissao: " + profissaoEscolhida.getValor());
        return profissaoEscolhida;

    }
}
