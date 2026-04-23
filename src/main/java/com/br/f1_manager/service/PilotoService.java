package com.br.f1_manager.service;

import com.br.f1_manager.client.F1ApiClient;
import com.br.f1_manager.dto.ApiResponseDto;
import com.br.f1_manager.dto.PilotoDto;
import com.br.f1_manager.model.Piloto;
import com.br.f1_manager.repository.PilotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PilotoService {

    private final F1ApiClient apiClient;
    private final PilotoRepository repository;

    public void carregarPilotosDaTemporada(int ano) {

        String endpoint = ano + "/drivers.json";
        ApiResponseDto resposta = apiClient.obterDados(endpoint, ApiResponseDto.class);

        List<PilotoDto> listaDePilotosDto = resposta.mrData().driverTable().pilotos();

        System.out.println("Encontrados " + listaDePilotosDto.size() + " pilotos. Aplicando filtros...");

        for (PilotoDto dto : listaDePilotosDto) {

            LocalDate dataNascimentoConvertida = null;
            if (dto.dataNascimento() != null) {
                dataNascimentoConvertida = LocalDate.parse(dto.dataNascimento());
            }

            int numeroConvertido = 0;
            if (dto.numero() != null) {
                numeroConvertido = Integer.parseInt(dto.numero());
            }

            // Só passa quem tem número diferente de zero e sigla diferente de nulo
            if (numeroConvertido != 0 && dto.sigla() != null) {

                Piloto pilotoOficial = new Piloto();

                pilotoOficial.setId(dto.id());
                pilotoOficial.setNome(dto.nome());
                pilotoOficial.setSobrenome(dto.sobrenome());
                pilotoOficial.setNumero(numeroConvertido);
                pilotoOficial.setSigla(dto.sigla());
                pilotoOficial.setNacionalidade(dto.nacionalidade());
                pilotoOficial.setDataNascimento(dataNascimentoConvertida);
                pilotoOficial.setEquipeAtual("Desconhecida");

                repository.save(pilotoOficial);
            }
        }
    }
}
