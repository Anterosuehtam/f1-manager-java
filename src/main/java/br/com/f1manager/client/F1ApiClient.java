package br.com.f1manager.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class F1ApiClient {

    public String buscarJsonPilotos(String ano) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String url = "https://api.jolpi.ca/ergast/f1/2026/drivers.json";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Criando um objeto da classe Response que utiliza o metodo send da classe Client
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {

            throw new RuntimeException("Falha ao se comunicar com a API da Jolpica-F1: " + e.getMessage());
        }
    }
}
