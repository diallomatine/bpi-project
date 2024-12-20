package com.bpi.project.bpi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Investissements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entreprise_investisseur_id")
    private Entreprise entrepriseInvestisseur;

    @ManyToOne
    @JoinColumn(name = "personne_investisseur_id")
    private PersonnePhysique personneInvestisseur;

    @ManyToOne
    @JoinColumn(name = "entreprise_investi_id", nullable = false)
    private Entreprise entrepriseInvesti;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal pourcentage;
}
