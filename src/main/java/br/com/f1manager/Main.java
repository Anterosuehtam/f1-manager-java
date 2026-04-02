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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            List<PilotoDto> listaDePilotosDto = apiResponse.mrData().driverTable().pilotos();

            List<Piloto> grid = new ArrayList<>();
            for (PilotoDto pilotoDto : listaDePilotosDto) {

                // Proteção para caso a data de nascimento for nula
                LocalDate dataNascimentoConvertida = null;
                if (pilotoDto.dataNascimento() != null) {
                    dataNascimentoConvertida = LocalDate.parse(pilotoDto.dataNascimento());
                }

                // Proteção do Número (Se for null, recebe o valor padrão 0)
                int numeroConvertido = 0;
                if (pilotoDto.numero() != null) {
                    numeroConvertido = Integer.parseInt(pilotoDto.numero());
                }

                // Instanciando o objeto da classe Piloto
                Piloto piloto = new Piloto(
                        pilotoDto.id(),
                        pilotoDto.nome(),
                        pilotoDto.sobrenome(),
                        numeroConvertido,
                        pilotoDto.sigla(),
                        pilotoDto.nacionalidade(),
                        dataNascimentoConvertida,
                        "Desconhecida"
                );
                grid.add(piloto);
            }
            System.out.println("\n--- Grid Completo Convertido para Piloto ---");
            for (Piloto piloto : grid) {
                // Metodo toString() da classe Piloto invocado automaticamente
                System.out.println(piloto);
            }

            //Aplicando um filtro: O piloto DEVE ter número diferente de 0 E sigla diferente de nulo
            List<Piloto> pilotosTitulares = grid.stream()
                                .filter(piloto -> piloto.getNumero() != 0 && piloto.getSigla() != null)
                                .collect(Collectors.toList());

            // Mostra apenas os pilotos titulares
            System.out.println("\n--- Grid Oficial de Titulares ---");
            for (Piloto piloto : pilotosTitulares) {
                System.out.println(piloto);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Opa! Ocorreu um erro ao tentar acessar a API da F1.");
            System.out.println("Detalhe do erro: " + e.getMessage());
        }
    }
}
