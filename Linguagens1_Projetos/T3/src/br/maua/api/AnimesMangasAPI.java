package br.maua.api;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * * Classe responsavel pela interação com a API do site api.jikan.moe/v3
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/10/2020
 * @version 1.0
 * */
public class AnimesMangasAPI {
    /**
     * Função responsavel por pesquisar um um titulo especifico de algum anime ou mangá.
     * @param tipo String que deve ser informada se é "anime" ou "manga".
     * @param nome tring que deve ser informada o titulo.
     * @return Uma estrutura JSON com os dados que foram requisitados.
     * @throws Exception lança uma exceção caso nao seja possivel criar o json.
     */
    public JSONObject formatoJson(String tipo, String nome) throws Exception{
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.jikan.moe/v3/search/"+tipo+"?q="+nome))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        return jsonObject;
    }
}
