package com.example.practicaFinal.prcticaFinal.repository;

import com.example.practicaFinal.prcticaFinal.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByObraSocial(Long obraSocial);
}
