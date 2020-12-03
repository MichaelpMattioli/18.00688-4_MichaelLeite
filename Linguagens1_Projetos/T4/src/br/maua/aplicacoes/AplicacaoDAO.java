package br.maua.aplicacoes;

import br.maua.DAO.PersonagemDAO;
import br.maua.enums.Profissao;
import br.maua.enums.Raca;
import br.maua.models.Personagem;

import java.util.List;
import java.util.Scanner;

public class AplicacaoDAO {
    private List<Personagem> personagemList;

    private PersonagemDAO personagemDAO;

    private Scanner scanner;

    public AplicacaoDAO() {
        this.personagemDAO = personagemDAO;

        this.scanner = new Scanner(System.in);
    }

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
            Raca raca = Raca.ASMODIANO;
            System.out.println("profissao:");
            Profissao profissao = Profissao.TECNOMAGO;
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
            System.out.print(nome);System.out.println(nome.getClass().getName());
            System.out.print(raca); System.out.println(raca.getClass().getName());
            System.out.print(profissao);System.out.println(profissao.getClass().getName());
            System.out.print(mana);System.out.println(mana.getClass().getName());
            System.out.print(ad);System.out.println(ad.getClass().getName());
            System.out.print(ap);System.out.println(ap.getClass().getName());
            System.out.print(def);System.out.println(def.getClass().getName());
            System.out.print(defM);System.out.println(defM.getClass().getName());
            System.out.print(velocidade);System.out.println(velocidade.getClass().getName());
            System.out.print(destreza);System.out.println(destreza.getClass().getName());
            System.out.print(experiencia);System.out.println(experiencia.getClass().getName());
            System.out.print(nivel);System.out.println(nivel.getClass().getName());

            Personagem personagem = new Personagem(
                    nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel
            );

            System.out.println(personagem);

            personagemDAO.create(new Personagem(
                    nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel
            ));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algum erro ocorreu no cadastramento");
        }
    }
}
