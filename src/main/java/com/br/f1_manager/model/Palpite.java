package com.br.f1_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "palpite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Palpite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_discord_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "etapa_id", nullable = false)
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "piloto_pole_id", nullable = false)
    private Piloto polePosition;

    @ManyToOne
    @JoinColumn(name = "piloto_vencedor_id", nullable = false)
    private Piloto vencedor;
}
