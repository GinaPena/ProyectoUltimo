package com.example.practicaFinal.prcticaFinal.Service.Implement;

import com.example.practicaFinal.prcticaFinal.Service.MedicoService;
import com.example.practicaFinal.prcticaFinal.domain.Medico;
import com.example.practicaFinal.prcticaFinal.repository.MedicosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MedicoServiceImpl  implements MedicoService{
    private final MedicosRepository medicosRepository;

    public MedicoServiceImpl(MedicosRepository medicosRepository) {
        this.medicosRepository = medicosRepository;
    }

    @Override
    public List<Medico> findAll() {
        return medicosRepository.findAll();
    }

    @Override
    public Medico findOne(Long medicoId) {
        return medicosRepository.findOne(medicoId);
    }

    @Override
    public Medico save(Medico medico) {
        return medicosRepository.save(medico);
        //return throw new RuntimeException("Ocurrio un error inesperado");
    }

    @Override
    public void delete(Medico medico) {
        medicosRepository.delete(medico);
       // throw new RuntimeException("Ocurrio un error inesperado");
    }

    @Override
    public List<Medico> findByEspecial(Long especial) {
        return medicosRepository.findByEspecial(especial);
    }
}
