package com.example.practicaFinal.prcticaFinal.repository;

import com.example.practicaFinal.prcticaFinal.domain.Medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicosRepository extends JpaRepository<Medico, Long>{
    List<Medico> findByEspecial(Long especial);
}
