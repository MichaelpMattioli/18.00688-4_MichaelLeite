package br.maua;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Submain {

    public static void main(String[] args) throws Exception {
        pokemonApi();
    }

    private static void pokemonApi() throws Exception{
        System.out.println("Digite o nome do pokemon");
        Scanner scanner1 = new Scanner(System.in);
        String pokemon = scanner1.nextLine();

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.jikan.moe/v3/"+ pokemon))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code:" + response.statusCode());
        System.out.println("Recebidos:");
        System.out.println(response.body());
    }
}
