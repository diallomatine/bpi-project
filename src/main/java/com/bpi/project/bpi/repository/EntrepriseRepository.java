package com.bpi.project.bpi.repository;

import com.bpi.project.bpi.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
