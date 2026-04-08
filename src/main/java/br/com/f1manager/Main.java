package br.com.f1manager;

import br.com.f1manager.client.F1ApiClient;
import br.com.f1manager.model.Equipe;
import br.com.f1manager.model.Piloto;
import br.com.f1manager.repository.ArquivoRepository;
import br.com.f1manager.service.EquipeService;
import br.com.f1manager.service.PilotoService;
import java.util.List;

public class Main {
    static void main(String[] args) {

        System.out.println("Conectando aos servidores da F1...\n");

        F1ApiClient clienteApi = new F1ApiClient();
        ArquivoRepository repositorio = new ArquivoRepository();

        PilotoService pilotoService = new PilotoService();
        EquipeService equipeService = new EquipeService();

        try {

            System.out.println("--- Pilotos ---");
            String jsonPilotos = clienteApi.buscarDados("2026/drivers");
            List<Piloto> pilotos = pilotoService.processarPilotosDaApi(jsonPilotos);

            // Mostrando os Pilotos
            for (Piloto piloto : pilotos) {
                System.out.println(piloto);
            }

            System.out.println("\n--- Equipes ---");
            String jsonEquipes = clienteApi.buscarDados("2026/constructors");
            List<Equipe> equipes = equipeService.processarEquipesDaApi(jsonEquipes);

            // Mostrando as equipes
            for (Equipe equipe : equipes) {
                System.out.println(equipe);
            }

            // Salvando os arquivos
            repositorio.salvar(pilotos, "grid-titulares-2026.json");
            repositorio.salvar(equipes, "equipes-2026.json");

        } catch (Exception e) {
            System.out.println("\nOps! Ocorreu um erro durante a execução do pipeline:");
            System.out.println(e.getMessage());
        }
    }
}
