package com.br.f1_manager.dto;

import java.time.LocalDate;

public record PilotoResponseDto(
        String id,
        String nome,
        LocalDate dataNascimento,
        String nacionalidade,
        Integer numero
) {
}
