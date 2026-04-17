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
@Table(name = "equipes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Equipe {

    @Id
    @Column(name = "id_equipe", length = 50)
    private String id;

    @Column(nullable = false)
    private String nome;

    private String nacionalidade;

}
