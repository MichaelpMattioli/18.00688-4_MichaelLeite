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
                    exibirPersonagens();
                    break;
                case 2:
                    System.out.print("Criação de personagem: ");
                    cadastrarPersonagem();
                    break;
                case 3:
                    System.out.print("Atualização do personagem: ");
                    atualizaPersonagem();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void menu() {
        System.out.println("Data Base Personagens");

        System.out.println("1 - Consultar personagens");
        System.out.println("2 - Cadastra personagem");
        System.out.println("3 - Alterar personagem");
        System.out.println("0 - Sair");
    }

    private void exibirPersonagens() {
        personagemList = personagemDAO.getAll();
        System.out.println("Personagens:");
        personagemList.forEach( personagem -> System.out.println(personagem));
    }

    private void cadastrarPersonagem(){
        try {
            System.out.println("Informe o ");
            System.out.println("nome:");String nome = scanner.next();
            System.out.println("raça:");Raca raca = escolhaRaca();
            System.out.println("profissao:");Profissao profissao = escolhaProfissao();
            System.out.println("mana:");Integer mana = scanner.nextInt();
            System.out.println("ad:");Integer ad = scanner.nextInt();
            System.out.println("ap:");Integer ap = scanner.nextInt();
            System.out.println("def:");Integer def = scanner.nextInt();
            System.out.println("defM:");Integer defM = scanner.nextInt();
            System.out.println("velocidade:");Integer velocidade = scanner.nextInt();
            System.out.println("destreza:");Integer destreza = scanner.nextInt();
            System.out.println("experiencia:");Integer experiencia = scanner.nextInt();
            System.out.println("nivel:");Integer nivel = scanner.nextInt();

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

    private void atualizaPersonagem(){
        System.out.println("Informe o nome do personagem que queira alterar.");

        personagemList = personagemDAO.getAll();
        System.out.println("Seus personagens são: ");
        personagemList.forEach( personagem -> System.out.println(personagem.getNome()));

        String nomeEscolhido = scanner.next();

        for (Personagem personagem : personagemList) {
            System.out.print(nomeEscolhido + " ->");
            System.out.println(personagem.getNome());
            if(nomeEscolhido.equals(personagem.getNome())){
                System.out.println(personagem);
                String nome = personagem.getNome();
                Raca raca = personagem.getRaca();
                Profissao profissao = personagem.getProfissao();
                Integer mana = personagem.getMana();
                Integer ad = personagem.getAd();
                Integer ap = personagem.getAp();
                Integer def = personagem.getDef();
                Integer defM = personagem.getDefM();
                Integer velocidade = personagem.getVelocidade();
                Integer destreza = personagem.getDestreza();
                Integer experiencia = personagem.getExperiencia();
                Integer nivel = personagem.getNivel();

                boolean alive = true;
                do{
                    menuUpdatePersonagem();
                    int opcao = Integer.parseInt(scanner.next());
                    switch (opcao){
                        case 0:
                            alive = false;
                            break;
                        case 1:
                            profissao = escolhaProfissao();
                            break;
                        case 2:
                            mana = escolhaProprietadeInteger("da Mana");
                            break;
                        case 3:
                            ad = escolhaProprietadeInteger("do Ad");
                            break;
                        case 4:
                            ap = escolhaProprietadeInteger("do Ap");
                            break;
                        case 5:
                            def = escolhaProprietadeInteger("da Def");
                            break;
                        case 6:
                            defM = escolhaProprietadeInteger("da DefM");
                            break;
                        case 7:
                            velocidade = escolhaProprietadeInteger("da Velocidade");
                            break;
                        case 8:
                            destreza = escolhaProprietadeInteger("da Destreza");
                            break;
                        case 9:
                            experiencia = escolhaProprietadeInteger("da Experiência");
                            break;
                        case 10:
                            nivel = escolhaProprietadeInteger("do Nivel");
                            break;
                        default:
                            System.out.println("Opcao Invalida!");
                    }

                }while(alive);

                personagemDAO.update( new Personagem(
                        nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel
                ));
                break;
            }
        }
    }

    private Integer escolhaProprietadeInteger(String propriedade) {
        System.out.print("Digite o valor " + propriedade);
        Integer escolha = scanner.nextInt();
        return escolha;
    }

    private void menuUpdatePersonagem() {
        System.out.println("Escolha a propriedade a ser mudada");

        System.out.println("1 - Profissao");
        System.out.println("2 - Mana");
        System.out.println("3 - Ad");
        System.out.println("4 - Ap");
        System.out.println("5 - Def");
        System.out.println("6 - DefM");
        System.out.println("7 - Velocidade");
        System.out.println("8 - Destreza");
        System.out.println("9 - Experiencia");
        System.out.println("10 - Nivel");
        System.out.println("0 - Sair");
    }
}
