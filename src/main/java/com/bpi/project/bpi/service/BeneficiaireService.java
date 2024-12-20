package com.bpi.project.bpi.service;

import com.bpi.project.bpi.dto.BeneficiaireDto;
import com.bpi.project.bpi.enums.FiltreBeneficiaireEnum;
import com.bpi.project.bpi.manager.BeneficiaireManager;
import com.bpi.project.bpi.models.Entreprise;
import com.bpi.project.bpi.repository.InvestissementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeneficiaireService {
    private final InvestissementsRepository investissementsRepository;
    private final BeneficiaireManager beneficiaireManager;

    public BeneficiaireDto getBeneficiaires(Entreprise entreprise, FiltreBeneficiaireEnum filtre) {

        BeneficiaireDto beneficiaireDto = new BeneficiaireDto();
        beneficiaireDto.setId(entreprise.getId());
        beneficiaireDto.setNomEntreprise(entreprise.getNom());
        beneficiaireDto.setListInvestisseurs(beneficiaireManager.getAllBeneficiaires(entreprise.getId(), filtre));

        return beneficiaireDto;
    }

}
