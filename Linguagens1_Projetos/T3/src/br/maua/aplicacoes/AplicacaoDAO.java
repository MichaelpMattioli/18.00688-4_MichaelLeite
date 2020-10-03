package br.maua.aplicacoes;

import br.maua.dao.AnimesDAO;
import br.maua.dao.MangasDAO;
import br.maua.models.Animes;
import br.maua.models.Mangas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoDAO {

    private List<Animes> animesList;
    private List<Mangas> mangasList;
    private AnimesDAO animesDAO;
    private MangasDAO mangasDAO;
    private Scanner scanner;

    public AplicacaoDAO() {
        animesList = new ArrayList<>();
        animesDAO = new AnimesDAO();

        mangasList = new ArrayList<>();
        mangasDAO = new MangasDAO();

        scanner = new Scanner(System.in);
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
                    System.out.println("Qual o anime que deseja consultar?");
                    System.out.print("Titulo: ");
                    String tituloAnime = "nome = " + "\"" + scanner.next() + "\"";

                    break;
                case 2:
                    System.out.println("Qual o mangá que deseja consultar?");
                    System.out.print("Titulo: ");
                    String tituloManga = "nome = " + "\"" + scanner.next() + "\"";

                    break;
                case 3:
                    exibirAnimes();
                    break;
                case 4:
                    exibirMangas();
                    break;
                case 5:
                    cadastrarNovoAnime();
                    break;
                case 6:
                    deletarAnime();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void menu() {
        System.out.println("Data Base Animes e Mangas");

        System.out.println("1 - Consultar Animes");
        System.out.println("2 - Consultar Mangas");
        System.out.println("3 - Listar Animes");
        System.out.println("4 - Listar Mangas");
        System.out.println("0 - Sair");
    }

    private void exibirAnimes() {
        animesList = animesDAO.getAll();
        System.out.println("Animes:");
        animesList.forEach( animes -> System.out.println(animes));
    }

    private void exibirMangas() {
        mangasList = mangasDAO.getAll();
        System.out.println("Mangas:");
        mangasList.forEach( mangas -> System.out.println(mangas) );
    }

    private void cadastrarNovoAnime(){
        String nome,sinopse,urlPoster;
        int quantidadeEpisodios;
        float nota;
        System.out.println("Informe os dados:");
        nome = scanner.next();
        sinopse = scanner.next();
        quantidadeEpisodios = Integer.parseInt(scanner.next());
        nota = Float.parseFloat(scanner.next());
       urlPoster = scanner.next();
        animesDAO.create(new Animes(
                nome, sinopse, quantidadeEpisodios, nota, urlPoster
        ));
    }

    private void cadastrarNovoManga(){
        String nome,sinopse, tipo, urlPoster;
        int quantidadeCapitulos, quantidadeVolumes;
        float nota;
        System.out.println("Informe os dados:");
        nome = scanner.next();
        sinopse = scanner.next();
        quantidadeCapitulos = Integer.parseInt(scanner.next());
        quantidadeVolumes = Integer.parseInt(scanner.next());
        tipo = scanner.next();
        nota = Float.parseFloat(scanner.next());
        urlPoster = scanner.next();
        mangasDAO.create(new Mangas(
                nome, sinopse, quantidadeCapitulos, quantidadeVolumes, tipo, nota, urlPoster
        ));
    }

    private void deletarAnime(){
        System.out.println("Codigo do produto:");
        String nome = scanner.next();
        Animes animes = new Animes(nome);
        animesDAO.delete(animes);
    }
}
