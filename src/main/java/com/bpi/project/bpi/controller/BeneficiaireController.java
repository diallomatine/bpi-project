package com.bpi.project.bpi.controller;

import com.bpi.project.bpi.dto.BeneficiaireDto;
import com.bpi.project.bpi.enums.FiltreBeneficiaireEnum;
import com.bpi.project.bpi.models.Entreprise;
import com.bpi.project.bpi.repository.EntrepriseRepository;
import com.bpi.project.bpi.service.BeneficiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/beneficiaire")
@RequiredArgsConstructor
public class BeneficiaireController {

    private final BeneficiaireService beneficiaireService;
    private final EntrepriseRepository entrepriseRepository;

    @GetMapping("")
    public ResponseEntity<BeneficiaireDto> getListBeneficiaire(@RequestParam("idEntreprise") Long idEntreprise,
                                                               @RequestParam(value = "filtre", defaultValue = "TOUS") FiltreBeneficiaireEnum filtre) {

        Optional<Entreprise> entrepriseOptional = entrepriseRepository.findById(idEntreprise);

        if (!entrepriseOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        BeneficiaireDto beneficiaireDto = beneficiaireService.getBeneficiaires(entrepriseOptional.get(), filtre);

        if (beneficiaireDto.getListInvestisseurs() == null || beneficiaireDto.getListInvestisseurs().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(beneficiaireDto);
    }
}
