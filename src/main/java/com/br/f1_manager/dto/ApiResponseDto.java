package com.br.f1_manager.dto;

import com.google.gson.annotations.SerializedName;

public record ApiResponseDto(@SerializedName("MRData") MRDataDto mrData) {
}
