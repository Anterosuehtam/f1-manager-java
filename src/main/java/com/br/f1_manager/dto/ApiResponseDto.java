package com.br.f1_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiResponseDto(@JsonProperty("MRData") MRDataDto mrData) {
}
