package com.jotajota.backend.repository;

import com.jotajota.backend.entity.AjustesClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAjustesClinicaRepository extends JpaRepository<AjustesClinica, Integer> {

}
