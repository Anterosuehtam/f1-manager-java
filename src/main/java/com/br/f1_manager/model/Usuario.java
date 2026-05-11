package com.br.f1_manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "discord_id", unique = true, nullable = false)
    private String discordId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int pontuacaoTotal = 0;


}
