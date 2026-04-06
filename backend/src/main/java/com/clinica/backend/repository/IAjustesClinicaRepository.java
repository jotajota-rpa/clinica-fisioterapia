package com.clinica.backend.repository;

import com.clinica.backend.entity.AjustesClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAjustesClinicaRepository extends JpaRepository<AjustesClinica, Integer> {

}
