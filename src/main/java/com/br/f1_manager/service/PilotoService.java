package com.br.f1_manager.service;

import com.br.f1_manager.client.F1ApiClient;
import com.br.f1_manager.dto.ApiResponseDto;
import com.br.f1_manager.dto.PilotoDto;
import com.br.f1_manager.dto.PilotoResponseDto;
import com.br.f1_manager.model.Piloto;
import com.br.f1_manager.repository.PilotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PilotoService {

    private final F1ApiClient apiClient;
    private final PilotoRepository repository;

    public void carregarPilotosDaTemporada(int ano) {

        String endpoint = ano + "/drivers.json";
        ApiResponseDto resposta = apiClient.obterDados(endpoint, ApiResponseDto.class);

        List<PilotoDto> listaDePilotosDto = resposta.mrData().driverTable().pilotos();

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

                repository.save(pilotoOficial);
            }
        }
    }

    public List<PilotoResponseDto> listarTodosPilotos() {

        List<Piloto> pilotosNoBanco = repository.findAll();

        return pilotosNoBanco.stream()
                .map(piloto -> new PilotoResponseDto(
                        piloto.getId(),
                        piloto.getNome(),
                        piloto.getDataNascimento(),
                        piloto.getNacionalidade(),
                        piloto.getNumero()
                ))
                .collect(Collectors.toList());
    }

}
