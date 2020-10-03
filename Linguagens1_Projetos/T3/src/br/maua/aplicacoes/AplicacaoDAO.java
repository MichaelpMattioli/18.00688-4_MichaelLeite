package br.maua.aplicacoes;

import br.maua.api.AnimesMangasAPI;
import br.maua.dao.AnimesDAO;
import br.maua.dao.MangasDAO;
import br.maua.models.Animes;
import br.maua.models.Mangas;
import org.json.JSONObject;

import java.util.List;
import java.util.Scanner;

/**
 * * Classe responsável pela implementação do DAO da Aplicação.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */

public class AplicacaoDAO {

    private List<Animes> animesList;
    private List<Mangas> mangasList;

    private AnimesDAO animesDAO;
    private MangasDAO mangasDAO;

    private Scanner scanner;

    private AnimesMangasAPI animesMangasAPI;
    private JSONObject json;

    /**
     * Construtor da AplicacaoDao, onde iram criar as variaveis necessarias para estruturar o DAO e a requisição de pesquisa.
     */

    public AplicacaoDAO() {

        animesDAO = new AnimesDAO();
        mangasDAO = new MangasDAO();

        scanner = new Scanner(System.in);

        animesMangasAPI = new AnimesMangasAPI();
        json = new JSONObject();
    }

    /**
     * Função responsável por rodar a aplicacaoDAO, de modo a interagir com o usuario por linha de comando.
     */

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
                    scanner = new Scanner(System.in);
                    String tituloAnime = scanner.nextLine()+"";
                    consultaDados(tituloAnime, opcao);
                    break;
                case 2:
                    System.out.println("Qual o mangá que deseja consultar?");
                    System.out.print("Titulo: ");
                    scanner = new Scanner(System.in);
                    String tituloManga = scanner.nextLine();
                    consultaDados(tituloManga, opcao);
                    break;
                case 3:
                    exibirAnimes();
                    break;
                case 4:
                    exibirMangas();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    /**
     * Menu principal
     */

    private void menu() {
        System.out.println("Data Base Animes e Mangas");

        System.out.println("1 - Consultar Animes");
        System.out.println("2 - Consultar Mangas");
        System.out.println("3 - Listar Animes");
        System.out.println("4 - Listar Mangas");
        System.out.println("0 - Sair");
    }

    /**
     * Função que exibe todos os animes cadastrados na data base
     */

    private void exibirAnimes() {
        animesList = animesDAO.getAll();
        System.out.println("Animes:");
        animesList.forEach( animes -> System.out.println(animes));
    }

    /**
     * Função que exibe todos os mangás cadastrados na data base
     */

    private void exibirMangas() {
        mangasList = mangasDAO.getAll();
        System.out.println("Mangás:");
        mangasList.forEach( mangas -> System.out.println(mangas));
    }

    /**
     * Função responsável por cadastrar os animes apartir dos dados do JSON.
     * @param nomeCondicional String que representa o titulo do anime que será pesquisado na api
     */

    private void cadastrarNovoAnime(String nomeCondicional){
        try {
            json = animesMangasAPI.formatoJson("anime", nomeCondicional.replace(" ", "%20")).getJSONArray("results").getJSONObject(0);
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

    /**
     * Função responsável por cadastrar os mangás apartir dos dados do JSON.
     * @param nomeCondicional String que representa o titulo do anime que será pesquisado na api
     */

    private void cadastrarNovoManga(String nomeCondicional){
        try {
            JSONObject json = animesMangasAPI.formatoJson("manga", nomeCondicional.replace(" ", "%20")).getJSONArray("results").getJSONObject(0);

            String nome = json.getString("title");
            String sinopse = json.getString("synopsis");
            Integer quantidadeCapitulos = json.getInt("chapters");
            Integer quantidadeVolumes = json.getInt("volumes");
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

    /**
     * Função responsavel por verificar se o titulo que o usuario digitou está na data base,
     * caso contrario ele oferece uma sugestão de um anime com o titulo que o usuario titulo,
     * perguntando se ele deseja adicionar o anime/mangá sugerido
     * @param titulo String que caracterisa o titulo que o usuario digitou.
     * @param numero Integer que diferencia se a escolha do usuario foi mangá ou anime.
     */

    private void consultaDados(String titulo, int numero){
        if(numero == 1){
            try {
                json = animesMangasAPI.formatoJson("anime", titulo.replace(" ", "%20")).getJSONArray("results").getJSONObject(0);
                if(!animesDAO.get( "nome = " + "\"" + titulo + "\"").toString().equals("[]")){
                    System.out.println("Titulo encontrado");
                    System.out.println("Informacoes sobre o titulo:");
                    System.out.println(animesDAO.get("nome = " + "\"" + titulo + "\""));
                }else{
                    System.out.println("Titulo \""+ titulo + "\" nao encontrado na data base");

                    if(animesDAO.get( "nome = " + "\"" + json.getString("title") + "\"").toString().equals("[]")) {
                        System.out.println("Deseja adicionar esse anime sugerido a sua data base?");
                        System.out.println("Nome: " + json.getString("title") + ", Poster: " + json.getString("image_url"));
                        System.out.println("0 - Nao");
                        System.out.println("1 - Sim");
                        int resposta = scanner.nextInt();

                        if (resposta == 1) {
                            cadastrarNovoAnime(titulo);
                        }
                    }
                    else{
                        System.out.println("Anime sugerido já cadastrado na data base");
                        System.out.println("Nome: " + json.getString("title") + ", Poster: " + json.getString("image_url"));
                    }
                }
            } catch (Exception e) {
                System.out.println("\nErro na consulta do anime ( minimo 3 caracteres )\n");
            }

        }
        if(numero == 2){
            try {
                json = animesMangasAPI.formatoJson("manga", titulo.replace(" ", "%20")).getJSONArray("results").getJSONObject(0);

                if(!animesDAO.get( "nome = " + "\"" + titulo + "\"").toString().equals("[]")){
                    System.out.println("Titulo encontrado");
                    System.out.println("Informacoes sobre o titulo:");
                    System.out.println(animesDAO.get("nome = " + "\"" + titulo + "\""));
                }else{
                    System.out.println("Titulo \""+ titulo + "\" nao encontrado na data base");

                    if(animesDAO.get( "nome = " + "\"" + json.getString("title") + "\"").toString().equals("[]")) {
                        System.out.println("Deseja adicionar esse manga sugerido a sua data base?");
                        System.out.println("Nome: " + json.getString("title") + ", Poster: " + json.getString("image_url"));
                        System.out.println("0 - Nao");
                        System.out.println("1 - Sim");
                        int resposta = scanner.nextInt();

                        if (resposta == 1) {
                            cadastrarNovoManga(titulo);
                        }
                    }
                    else{
                        System.out.println("Manga sugerido já cadastrado na data base");
                        System.out.println("Nome: " + json.getString("title") + ", Poster: " + json.getString("image_url"));
                    }
                }
            } catch (Exception e) {
                System.out.println("\nErro na consulta do manga ( minimo 3 caracteres )\n");
            }

        }
    }

}
