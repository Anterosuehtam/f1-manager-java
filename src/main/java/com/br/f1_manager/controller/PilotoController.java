package com.br.f1_manager.controller;

import com.br.f1_manager.dto.PilotoResponseDto;
import com.br.f1_manager.service.PilotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pilotos")
@RequiredArgsConstructor
public class PilotoController {

    private final PilotoService pilotoService;

    @GetMapping("/importar/{ano}")
    public ResponseEntity<String> importarPilotos(@PathVariable int ano) {
        pilotoService.carregarPilotosDaTemporada(ano);

        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso: Grid de pilotos de " + ano + " criado no banco.");
    }

    @GetMapping
    public ResponseEntity<List<PilotoResponseDto>> listarTodos() {
        List<PilotoResponseDto> listaDePilotos = pilotoService.listarTodosPilotos();

        return ResponseEntity.ok(listaDePilotos);
    }
}
