package com.bpi.project.bpi.dto;

import com.bpi.project.bpi.enums.TypeBeneficiaireEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class InvestisseurDto {
    private Long id;
    private String nom;
    private TypeBeneficiaireEnum typeInvestisseur;
    private BigDecimal pourcentage;
}
