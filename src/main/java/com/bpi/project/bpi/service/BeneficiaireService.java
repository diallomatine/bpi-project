package com.bpi.project.bpi.service;

import com.bpi.project.bpi.FiltreBeneficiaireEnum;
import com.bpi.project.bpi.dto.BeneficiaireProjection;
import com.bpi.project.bpi.repository.InvestissementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiaireService {
    private final InvestissementsRepository investissementsRepository;

    public List<BeneficiaireProjection> getBeneficiaires(Long idEntreprise, FiltreBeneficiaireEnum filtre) {
        return investissementsRepository.getAllBeneficiariesByEntrepriseId(idEntreprise, filtre.name());
    }

}
