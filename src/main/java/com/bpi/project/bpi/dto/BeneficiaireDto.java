package com.bpi.project.bpi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BeneficiaireDto {
    private Long id;
    private String nomEntreprise;
    private List<InvestisseurDto> listInvestisseurs;
}
