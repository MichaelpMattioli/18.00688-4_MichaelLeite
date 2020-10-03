//Michael Pedroza Mattioli Leite RA: 18.00688-4

package br.maua;

import br.maua.aplicacoes.AplicacaoDAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws Exception {
        AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
        aplicacaoDAO.run();
    }

    private static void leituraJava11() throws Exception{
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.jikan.moe/v3/anime/1"))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code:" + response.statusCode());
        System.out.println("Recebidos:");
        System.out.println(response.body());
    }
}
