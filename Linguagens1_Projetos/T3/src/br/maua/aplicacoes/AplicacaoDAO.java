package br.maua.aplicacoes;

import br.maua.api.AnimesMangasAPI;
import br.maua.dao.AnimesDAO;
import br.maua.dao.MangasDAO;
import br.maua.models.Animes;
import br.maua.models.Mangas;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoDAO {

    private List<Animes> animesList;
    private List<Mangas> mangasList;

    private AnimesDAO animesDAO;
    private MangasDAO mangasDAO;

    private Scanner scanner;

    private AnimesMangasAPI animesMangasAPI;

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
                    consultaDados(tituloAnime, opcao);
                    break;
                case 2:
                    System.out.println("Qual o mangá que deseja consultar?");
                    System.out.print("Titulo: ");
                    String tituloManga = "nome = " + "\"" + scanner.next() + "\"";
                    consultaDados(tituloManga, opcao);
                    break;
                case 3:
                    exibirAnimes();
                    break;
                case 4:
                    exibirMangas();
                    break;
                case 5:
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

    private void cadastrarNovoAnime(String nomeCondicional){
        try {
            JSONObject json = animesMangasAPI.formatoJson("anime", nomeCondicional).getJSONArray("results").getJSONObject(0);
            String nome = json.getString("title");
            String sinopse = json.getString("synopsis");
            Integer quantidadeEpisodios = json.getInt("episodes");
            Float nota = json.getFloat("score");
            String urlPoster = json.getString("image_url");

            animesDAO.create(new Animes(
                    nome, sinopse, quantidadeEpisodios, nota, urlPoster
            ));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algum erro ocorreu no cadastramento");
        }
    }

    private void cadastrarNovoManga(String nomeCondicional){
        try {
            JSONObject json = animesMangasAPI.formatoJson("anime", nomeCondicional).getJSONArray("results").getJSONObject(0);
            String nome = json.getString("title");
            String sinopse = json.getString("synopsis");
            Integer quantidadeCapitulos = json.getInt("episodes");
            Integer quantidadeVolumes = json.getInt("episodes");
            String tipo = json.getString("type");
            Float nota = json.getFloat("score");
            String urlPoster = json.getString("image_url");

            mangasDAO.create(new Mangas(
                    nome, sinopse, quantidadeCapitulos, quantidadeVolumes, tipo, nota, urlPoster
            ));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algum erro ocorreu no cadastramento");
        }
    }

    private void deletarAnime(){
        System.out.println("Codigo do produto:");
        String nome = scanner.next();
        Animes animes = new Animes(nome);
        animesDAO.delete(animes);
    }

    private void consultaDados(String titulo, int numero){

        if(numero == 1 && !animesDAO.get(titulo).toString().equals("[]")){
            System.out.println("Titulo encontrado");
            System.out.println("Informacoes sobre o titulo:");
            System.out.println(animesDAO.get(titulo));
        }else if(numero == 1 && animesDAO.get(titulo).toString().equals("[]")){
            System.out.println("Titulo nao encontrada na data base");
            System.out.println("Deseja adicionar esse anime a sua data base?");

            System.out.println("0 - Nao");
            System.out.println("1 - Sim");
            int resposta = scanner.nextInt();

            if(resposta == 1){
                cadastrarNovoAnime(titulo);
            }
        }

        if(numero == 2 && !mangasDAO.get(titulo).toString().equals("[]")){
            System.out.println("Titulo encontrado");
            System.out.println("Informacoes sobre o titulo:");
            System.out.println(mangasDAO.get(titulo));
        }else if(numero == 2 && mangasDAO.get(titulo).toString().equals("[]")){
            System.out.println("Titulo nao encontrada na data base");
            System.out.println("Deseja adicionar esse anime a sua data base?");

            System.out.println("0 - Nao");
            System.out.println("1 - Sim");
            int resposta = scanner.nextInt();

            if(resposta == 1){
                cadastrarNovoManga(titulo);
            }
        }

    }

}
