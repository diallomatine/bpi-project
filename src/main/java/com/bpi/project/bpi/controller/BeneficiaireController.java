package com.bpi.project.bpi.controller;

import com.bpi.project.bpi.FiltreBeneficiaireEnum;
import com.bpi.project.bpi.dto.BeneficiaireProjection;
import com.bpi.project.bpi.models.Entreprise;
import com.bpi.project.bpi.repository.EntrepriseRepository;
import com.bpi.project.bpi.service.BeneficiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiaire")
@RequiredArgsConstructor
public class BeneficiaireController {

    private final BeneficiaireService beneficiaireService;
    private final EntrepriseRepository entrepriseRepository;

    @GetMapping("")
    public ResponseEntity<List<BeneficiaireProjection>> getListBeneficiaire(@RequestParam("idEntreprise") Long idEntreprise,
                                                                            @RequestParam(value = "filtre", defaultValue = "TOUS") FiltreBeneficiaireEnum filtre) {

        Optional<Entreprise> entrepriseOptional = entrepriseRepository.findById(idEntreprise);

        if (!entrepriseOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<BeneficiaireProjection> beneficiaireProjections = beneficiaireService.getBeneficiaires(idEntreprise, filtre);

        if (beneficiaireProjections == null || beneficiaireProjections.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(beneficiaireProjections);
    }
}
