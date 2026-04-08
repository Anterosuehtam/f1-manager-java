package br.com.f1manager.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record ConstructorTableDto(@SerializedName("Constructors")List<EquipeDto> equipes) {
}
