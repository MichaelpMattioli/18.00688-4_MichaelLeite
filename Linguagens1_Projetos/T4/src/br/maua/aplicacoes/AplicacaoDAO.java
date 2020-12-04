package br.maua.aplicacoes;

import br.maua.DAO.PersonagemDAO;
import br.maua.enums.Equipamentos;
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
            int opcao = isInteger();
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    exibirPersonagens();
                    break;
                case 2:
                    System.out.println("Criação de personagem: ");
                    cadastrarPersonagem();
                    break;
                case 3:
                    System.out.println("Atualização do personagem: ");
                    atualizaPersonagem();
                    break;
                case 4:
                    System.out.println("Deletar personagem: ");
                    deletarPersonagem();
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
        System.out.println("4 - Deletar personagem");
        System.out.println("0 - Sair");
    }

    private void exibirPersonagens() {
        personagemList = personagemDAO.getAll();
        System.out.println("Personagens:");
        personagemList.forEach( personagem -> System.out.println(personagem));
    }

    private void cadastrarPersonagem(){
        try {
            System.out.print("Informe o nome: ");String nome = scanner.next();System.out.println("");
            Raca raca = escolhaRaca();System.out.println("");
            Profissao profissao = escolhaProfissao();System.out.println("");
            System.out.print("Informe a mana: ");Integer mana = isInteger();System.out.println("");
            System.out.print("Informe o ad: ");Integer ad = isInteger();System.out.println("");
            System.out.print("Informe o ap: ");Integer ap = isInteger();System.out.println("");
            System.out.print("Informe a def: ");Integer def = isInteger();System.out.println("");
            System.out.print("Informe a defM: ");Integer defM = isInteger();System.out.println("");
            System.out.print("Informe a velocidade: ");Integer velocidade = isInteger();System.out.println("");
            System.out.print("Informe a destreza: ");Integer destreza = isInteger();System.out.println("");
            System.out.print("Informe a experiencia: ");Integer experiencia = isInteger();System.out.println("");
            System.out.print("Informe o nivel: ");Integer nivel = isInteger();System.out.println("");

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

    private void atualizaPersonagem(){
        System.out.println("Informe o nome do personagem que queira alterar.");

        personagemList = personagemDAO.getAll();
        System.out.println("Seus personagens são: ");
        personagemList.forEach( personagem -> System.out.println(personagem.getNome()));

        String nomeEscolhido = scanner.next();

        boolean flagNomeEncontrado = false;

        for (Personagem personagem : personagemList) {
            if(nomeEscolhido.equals(personagem.getNome())){
                flagNomeEncontrado = true;
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
                Equipamentos cabeca = personagem.getCabeca();
                Equipamentos tronco = personagem.getTronco();
                Equipamentos pernas = personagem.getPernas();
                Equipamentos pes = personagem.getPes();

                System.out.println("Atualize sua armadura!");

                boolean alive = true;
                do{
                    menuUpdatePersonagem();
                    int opcao = isInteger();
                    switch (opcao){
                        case 0:
                            alive = false;
                            break;
                        case 1:
                            profissao = escolhaProfissao();
                            break;
                        case 2:
                            mana = escolhaProprietadeInteger("da Mana") + cabeca.getMana();
                            break;
                        case 3:
                            ad = escolhaProprietadeInteger("do Ad") + cabeca.getAd();
                            break;
                        case 4:
                            ap += escolhaProprietadeInteger("do Ap") + cabeca.getAp();
                            break;
                        case 5:
                            def += escolhaProprietadeInteger("da Def") + cabeca.getDef();
                            break;
                        case 6:
                            defM = escolhaProprietadeInteger("da DefM") + cabeca.getDefM();
                            break;
                        case 7:
                            velocidade = escolhaProprietadeInteger("da Velocidade") + cabeca.getVelocidade();
                            break;
                        case 8:
                            destreza = escolhaProprietadeInteger("da Destreza") + cabeca.getDestreza();
                            break;
                        case 9:
                            experiencia = escolhaProprietadeInteger("da Experiência");
                            break;
                        case 10:
                            nivel = escolhaProprietadeInteger("do Nivel");
                            break;
                        case 11:
                            boolean alive1 = true;
                            do{
                                menuArmadura();
                                int opcao1 = isInteger();
                                switch (opcao1){
                                    case 0:
                                        alive1 = false;
                                        break;
                                    case 1:
                                        Equipamentos armaduraAnterior1 = cabeca;
                                        cabeca = escolhaArmadura(1,personagem);
                                        mana += atualizaAtributo(cabeca, "mana") - armaduraAnterior1.getMana();
                                        ad += atualizaAtributo(cabeca, "ad") - armaduraAnterior1.getAd();
                                        ap += atualizaAtributo(cabeca, "ap") - armaduraAnterior1.getAp();
                                        def += atualizaAtributo(cabeca,"def") - armaduraAnterior1.getDef();
                                        defM += atualizaAtributo(cabeca,"defM") - armaduraAnterior1.getDefM();
                                        velocidade += atualizaAtributo(cabeca,"velocidade") - armaduraAnterior1.getVelocidade();
                                        destreza += atualizaAtributo(cabeca,"destreza") - armaduraAnterior1.getDestreza();
                                        break;
                                    case 2:
                                        Equipamentos armaduraAnterior2 = tronco;
                                        tronco = escolhaArmadura(2,personagem);
                                        mana += atualizaAtributo(tronco, "mana") - armaduraAnterior2.getMana();
                                        ad += atualizaAtributo(tronco, "ad") - armaduraAnterior2.getAd();
                                        ap += atualizaAtributo(tronco, "ap") - armaduraAnterior2.getAp();
                                        def += atualizaAtributo(tronco,"def") - armaduraAnterior2.getDef();
                                        defM += atualizaAtributo(tronco,"defM") - armaduraAnterior2.getDefM();
                                        velocidade += atualizaAtributo(tronco,"velocidade") - armaduraAnterior2.getVelocidade();
                                        destreza += atualizaAtributo(tronco,"destreza") - armaduraAnterior2.getDestreza();
                                        break;
                                    case 3:
                                        Equipamentos armaduraAnterior3 = pernas;
                                        pernas = escolhaArmadura(3,personagem);
                                        mana += atualizaAtributo(pernas, "mana") - armaduraAnterior3.getMana();
                                        ad +=  atualizaAtributo(pernas, "ad") - armaduraAnterior3.getAd();
                                        ap += atualizaAtributo(pernas, "ap") - armaduraAnterior3.getAp();
                                        def += atualizaAtributo(pernas,"def") - armaduraAnterior3.getDef();
                                        defM += atualizaAtributo(pernas,"defM") - armaduraAnterior3.getDefM();
                                        velocidade += atualizaAtributo(pernas,"velocidade") - armaduraAnterior3.getVelocidade();
                                        destreza += atualizaAtributo(pernas,"destreza") - armaduraAnterior3.getDestreza();
                                        break;
                                    case 4:
                                        Equipamentos armaduraAnterior4 = pes;
                                        pes = escolhaArmadura(4,personagem);
                                        mana += atualizaAtributo(pes, "mana") - armaduraAnterior4.getMana();
                                        ad += atualizaAtributo(pes, "ad") - armaduraAnterior4.getAd();
                                        ap += atualizaAtributo(pes, "ap") - armaduraAnterior4.getAp();
                                        def += atualizaAtributo(pes,"def") - armaduraAnterior4.getDef();
                                        defM += atualizaAtributo(pes,"defM") - armaduraAnterior4.getDefM();
                                        velocidade += atualizaAtributo(pes,"velocidade") - armaduraAnterior4.getVelocidade();
                                        destreza += atualizaAtributo(pes,"destreza") - armaduraAnterior4.getDestreza();
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                }
                            }while(alive1);
                            break;
                    }

                }while(alive);

                personagemDAO.update( new Personagem(
                        nome, raca, profissao, mana, ad, ap, def, defM, velocidade, destreza, experiencia, nivel, cabeca, tronco, pernas, pes
                ));
                break;
            }
        }
        if(!flagNomeEncontrado){
            System.out.println("Personagem não encontrado! Verifique se o nome foi digitado corretamente.");
        }
    }

    private Integer atualizaAtributo(Equipamentos equipamento, String nomeDaVariavel) {
        if(nomeDaVariavel == "mana"){
            return equipamento.getMana();
        }
        if(nomeDaVariavel == "ad"){
            return equipamento.getAd();
        }
        if(nomeDaVariavel == "ap"){
            return equipamento.getAp();
        }
        if(nomeDaVariavel == "def"){
            return equipamento.getDef();
        }
        if(nomeDaVariavel == "defM"){
            return equipamento.getDefM();
        }
        if(nomeDaVariavel == "velocidade"){
            return equipamento.getVelocidade();
        }
        if(nomeDaVariavel == "destreza"){
            return equipamento.getDestreza();
        }
        return 0;
    }

    private void deletarPersonagem(){
        System.out.println("Informe o nome do personagem que deseja deletar.");

        personagemList = personagemDAO.getAll();
        System.out.println("Seus personagens são: ");
        personagemList.forEach( personagem -> System.out.println(personagem.getNome()));
        System.out.println("_____________________________________");
        System.out.println("0 - Desistir");


        String nomeEscolhido = scanner.next();

        int i=0;

        for (Personagem personagem : personagemList) {
            if(nomeEscolhido.equals(personagem.getNome())){
                i++;
                personagemDAO.delete(personagem);
            }
        }
        if( i !=1 && !nomeEscolhido.equals("0")){
            System.out.println("Personagem não encontrado! Verifique se o nome foi digitado corretamente.");
        }
    }

    private Integer escolhaProprietadeInteger(String propriedade) {
        System.out.print("Digite o novo valor " + propriedade +": ");
        Integer escolha = isInteger();
        return escolha;
    }

    private void menuUpdatePersonagem() {
        System.out.println("Escolha o que deseja alterar:");

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
        System.out.println("11 - Armadura");
        System.out.println("0 - Sair");
    }

    private void menuArmadura(){
        System.out.println("Escolha o local em que queira colocar a uma armadura:");
        System.out.println("1 - Cabeça");
        System.out.println("2 - Tronco");
        System.out.println("3 - Pernas");
        System.out.println("4 - Pés");
        System.out.println("0 - Sair");
    }

    private Integer isInteger(){
        Integer integer = null;
        boolean flag = true;

        do{
            String integerAux = scanner.next();

           try{
               integer = Integer.parseInt(integerAux);
               flag = false;
           }catch (Exception e){
               System.out.println("Valor invalido! Verifique se é um inteiro.");
               System.out.print("Tente novamente: ");
           }

        }while (flag);
        return integer;
    }

    private Raca escolhaRaca() {
        Raca racaEscolhida = null;

        System.out.println("Escolha sua raça: ");
        int i = 0;
        for (Raca raca: Raca.values()) {
            i++;
            System.out.println(i + " - " + raca.getValor());
        }
        int escolha = isInteger();

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
        int escolha = isInteger();

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

    private Equipamentos escolhaArmadura(int localDaArmadura, Personagem personagem) {
        Equipamentos equipamentosEscolhida = Equipamentos.NONE;

        if( localDaArmadura == 1){
            equipamentosEscolhida = personagem.getCabeca();
        }else if( localDaArmadura == 2){
            equipamentosEscolhida = personagem.getTronco();
        }else if( localDaArmadura == 3){
            equipamentosEscolhida = personagem.getPernas();
        }else if( localDaArmadura == 4){
            equipamentosEscolhida = personagem.getPes();
        }

        System.out.println("Escolha seu Equipamento: ");
        System.out.println("0 - Retirar equipamento");
        int i = 0;
        for (Equipamentos equipamentos: Equipamentos.values()) {
            if(equipamentos.getLocal() == localDaArmadura){
                i++;
                System.out.println(i + " - " + equipamentos);
            }

        }
        int escolha = isInteger();

        int j = 0;
        for (Equipamentos equipamentos: Equipamentos.values()) {
            if(equipamentos.getLocal() == localDaArmadura){
                j++;
                if(escolha == j){
                    equipamentosEscolhida = equipamentos;
                }
                if(escolha == 0){
                    equipamentosEscolhida = Equipamentos.NONE;
                }
            }
        }

        System.out.println("Voce escolheu a armadura: " + equipamentosEscolhida);
        return equipamentosEscolhida;

    }
}
