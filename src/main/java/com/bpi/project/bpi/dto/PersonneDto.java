package com.bpi.project.bpi.dto;

import com.bpi.project.bpi.enums.TypeBeneficiaireEnum;
import com.bpi.project.bpi.models.PersonnePhysique;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class PersonneDto extends InvestisseurDto {
    private String prenom;

    public PersonneDto(Optional<PersonnePhysique> personnePhysiqueOptional) {
        super();

        if (personnePhysiqueOptional.isPresent()) {
            this.prenom = personnePhysiqueOptional.get().getPrenom();
            this.setNom(personnePhysiqueOptional.get().getNom());
            this.setId(personnePhysiqueOptional.get().getId());
            this.setTypeInvestisseur(TypeBeneficiaireEnum.PERSONNE);
        }
    }
}
