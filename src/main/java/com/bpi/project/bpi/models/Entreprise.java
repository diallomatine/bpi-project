package com.bpi.project.bpi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entreprise {

    @Id
    private Long id;

    @Column(nullable = false, length = 255)
    private String nom;
}
