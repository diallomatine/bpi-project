package com.bpi.project.bpi.dto;

import com.bpi.project.bpi.enums.TypeBeneficiaireEnum;
import com.bpi.project.bpi.models.Entreprise;

import java.util.Optional;

public class EntrepriseDto extends InvestisseurDto {
    public EntrepriseDto(Optional<Entreprise> entrepriseOptional) {
        super();
        if (entrepriseOptional.isPresent()) {
            this.setId(entrepriseOptional.get().getId());
            this.setNom(entrepriseOptional.get().getNom());
            this.setTypeInvestisseur(TypeBeneficiaireEnum.ENTREPRISE);
        }
    }
}
