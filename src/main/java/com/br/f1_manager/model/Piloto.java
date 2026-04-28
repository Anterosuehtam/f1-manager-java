package com.br.f1_manager.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "piloto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    @Id
    @Column(name = "id_piloto")
    private String id;

    @Column(nullable = false)
    private String nome;

    private String sobrenome;

    private int numero;

    private String sigla;

    private String nacionalidade;

    private LocalDate dataNascimento;

}
