package com.br.f1_manager.dto;

import com.google.gson.annotations.SerializedName;

public record PilotoDto(@SerializedName("driverId") String id,
                        @SerializedName("givenName") String nome,
                        @SerializedName("familyName")String sobrenome,
                        @SerializedName("permanentNumber") String numero,
                        @SerializedName("code") String sigla,
                        @SerializedName("nationality") String nacionalidade,
                        @SerializedName("dateOfBirth") String dataNascimento) {
}
