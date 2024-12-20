package com.bpi.project.bpi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class RelationDetention {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_entreprise_id", nullable = false)
    private Entreprise sourceEntreprise;

    @ManyToOne
    @JoinColumn(name = "personne_physique_id", nullable = false)
    private PersonnePhysique personnePhysique;

    @ManyToOne
    @JoinColumn(name = "cible_entreprise_id", nullable = false)
    private Entreprise cibleEntreprise;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal pourcentage;
}
