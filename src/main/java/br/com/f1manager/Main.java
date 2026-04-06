package br.com.f1manager;

import br.com.f1manager.client.F1ApiClient;
import br.com.f1manager.model.Piloto;
import br.com.f1manager.repository.ArquivoRepository;
import br.com.f1manager.service.PilotoService;
import java.util.List;

public class Main {
    static void main(String[] args) {

        System.out.println("Conectando aos servidores da F1...\n");

        F1ApiClient clienteApi = new F1ApiClient();
        String jsonBody = clienteApi.buscarJsonPilotos("2026");

        PilotoService pilotoService = new PilotoService();
        List<Piloto> pilotosTitulares = pilotoService.processarPilotosDaApi(jsonBody);

        System.out.println("--- Grid Oficial ---");
        for (Piloto piloto : pilotosTitulares) {
            System.out.println(piloto);
        }

        ArquivoRepository repositorio = new ArquivoRepository();
        repositorio.salvarPilotos(pilotosTitulares, "grid-titulares-2026.json");

    }
}
