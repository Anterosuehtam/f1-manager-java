package com.br.f1_manager.controller;

import com.br.f1_manager.dto.EquipeResponseDto;
import com.br.f1_manager.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeService equipeService;

    @GetMapping("/importar/{ano}")
    public ResponseEntity<String> importarEquipes(@PathVariable int ano) {
        equipeService.carregarEquipesDaTemporada(ano);

        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso: Equipes da temporada " + ano + " foram importadas.");
    }

    @GetMapping
    public ResponseEntity<List<EquipeResponseDto>> listarTodas() {
        List<EquipeResponseDto> listaDeEquipes = equipeService.listarTodasEquipes();

        return ResponseEntity.ok(listaDeEquipes);
    }
}
