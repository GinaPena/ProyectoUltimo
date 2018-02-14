package com.example.practicaFinal.prcticaFinal.Service;

import com.example.practicaFinal.prcticaFinal.domain.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> findAll();

    Medico findOne(Long medicoId);

    Medico save(Medico medico);

    void delete(Medico medico);

    List<Medico> findByEspecial(Long especial);
}
