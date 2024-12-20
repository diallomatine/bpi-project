package com.bpi.project.bpi.repository;

import com.bpi.project.bpi.dto.BeneficiaireProjection;
import com.bpi.project.bpi.models.Investissements;
import com.bpi.project.bpi.requete.RequeteBeneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InvestissementsRepository extends JpaRepository<Investissements, Long> {

    @Query(value = RequeteBeneficiaire.GET_ALL_BENEFICIAIRES, nativeQuery = true)
    List<BeneficiaireProjection> getAllBeneficiariesByEntrepriseId(@Param("entrepriseId") Long entrepriseId, @Param("return_type") String returnType);
}
