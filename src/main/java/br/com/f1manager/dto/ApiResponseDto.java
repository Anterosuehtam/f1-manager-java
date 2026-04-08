package br.com.f1manager.dto;

import com.google.gson.annotations.SerializedName;

public record ApiResponseDto(@SerializedName("MRData") MRDataDto mrData) {
}
