package br.com.f1manager;

import br.com.f1manager.model.ApiResponseDto;
import br.com.f1manager.model.Piloto;
import br.com.f1manager.model.PilotoDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class Main {
    static void main(String[] args) {

        System.out.println("Conectando aos servidores da F1...\n");

        try {
            // Criando um objeto da classe HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Criando um objeto da classe Request
            String url = "https://api.jolpi.ca/ergast/f1/2026/drivers.json";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Criando um objeto da classe Response que utiliza o metodo send da classe Client
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonBody = response.body();
            //System.out.println(response.body());

            // Criando o gson
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            ApiResponseDto apiResponse = gson.fromJson(jsonBody, ApiResponseDto.class);

            java.util.List<PilotoDto> listaDePilotosDto = apiResponse.mrData().driverTable().pilotos();

            System.out.println("\n--- Pilotos Carregados da API ---");
            for (PilotoDto pilotoDto : listaDePilotosDto) {
                System.out.println(pilotoDto.nome() + " " + pilotoDto.sobrenome() + " (" + pilotoDto.sigla() + ")");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Opa! Ocorreu um erro ao tentar acessar a API da F1.");
            System.out.println("Detalhe do erro: " + e.getMessage());
        }

    }
}
