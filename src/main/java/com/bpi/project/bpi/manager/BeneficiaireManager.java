package com.bpi.project.bpi.manager;

import com.bpi.project.bpi.dto.BeneficiaireProjection;
import com.bpi.project.bpi.dto.EntrepriseDto;
import com.bpi.project.bpi.dto.InvestisseurDto;
import com.bpi.project.bpi.dto.PersonneDto;
import com.bpi.project.bpi.enums.FiltreBeneficiaireEnum;
import com.bpi.project.bpi.repository.EntrepriseRepository;
import com.bpi.project.bpi.repository.InvestissementsRepository;
import com.bpi.project.bpi.repository.PersonnePhysiqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BeneficiaireManager {
    private final InvestissementsRepository investissementsRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final PersonnePhysiqueRepository personnePhysiqueRepository;

    public List<InvestisseurDto> getAllBeneficiaires(Long idEntreprise, FiltreBeneficiaireEnum filtre) {
        List<BeneficiaireProjection> beneficiaireProjectionsList = investissementsRepository.getAllBeneficiariesByEntrepriseId(idEntreprise, filtre.name());
        List<InvestisseurDto> listInvestisseur = new ArrayList<>();
        for (BeneficiaireProjection beneficiaireProjection : beneficiaireProjectionsList) {
            listInvestisseur.add(buildInvestisseurDto(beneficiaireProjection, beneficiaireProjection.getEntrepriseInvestisseurId() != null));
        }

        return listInvestisseur;
    }

    private InvestisseurDto buildInvestisseurDto(BeneficiaireProjection beneficiaireProjection, boolean isEntreprise) {
        InvestisseurDto investisseurDto;

        if (isEntreprise) {
            investisseurDto = new EntrepriseDto(entrepriseRepository.findById(beneficiaireProjection.getEntrepriseInvestisseurId()));
        } else {
            investisseurDto = new PersonneDto(personnePhysiqueRepository.findById(beneficiaireProjection.getPersonneInvestisseurId()));
        }
        investisseurDto.setPourcentage(beneficiaireProjection.getPourcentage());

        return investisseurDto;
    }
}
