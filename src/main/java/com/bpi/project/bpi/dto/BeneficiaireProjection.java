package com.bpi.project.bpi.dto;

import java.math.BigDecimal;

public interface BeneficiaireProjection {

    Long getEntrepriseInvestisseurId();

    Long getEntrepriseInvestiId();

    Long getPersonneInvestisseurId();

    BigDecimal getPourcentage();
}
