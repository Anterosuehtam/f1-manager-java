package br.com.f1manager.dto;

import com.google.gson.annotations.SerializedName;

public record EquipeDto(@SerializedName ("constructorId") String id,
                        @SerializedName ("name") String nome,
                        @SerializedName ("nationality") String nacionalidade) {
}
