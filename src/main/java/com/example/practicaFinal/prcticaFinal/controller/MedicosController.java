package com.example.practicaFinal.prcticaFinal.controller;

import com.example.practicaFinal.prcticaFinal.Service.MedicoService;
import com.example.practicaFinal.prcticaFinal.domain.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MedicosController
{
    @Autowired
    private MedicoService medicoService;

    public MedicosController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/Medicos")
    public List<Medico> getAllMedicos(){
        return medicoService.findAll();
        }
    @GetMapping("/Medicos/{idMedico}")
    public ResponseEntity<Medico> getMedicosById(@PathVariable(value = "idMedico") Long medicoId) {
        Medico medico = medicoService.findOne(medicoId);
        if(medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(medico);
    }
    // Create a new Medico
    @PostMapping("/Medicos")
    public Medico createMedicos(@Valid @RequestBody Medico medico) {
        return medicoService.save(medico);
    }


    // Update a Medico
    @PutMapping("/Medicos/{idMedico}")
    public ResponseEntity<Medico> updateMedicos(@PathVariable(value = "idMedico") Long medicoId,
                                                @Valid @RequestBody Medico medicoDetails) {
        Medico medico = medicoService.findOne(medicoId);
        if(medico == null) {
            return ResponseEntity.notFound().build();
        }
        medico.setNombre(medicoDetails.getNombre());

        medico.setEstado(medicoDetails.getEstado());
        medicoDetails.setEspecial(medico.getEspecial());


        Medico updateMEdicos= medicoService.save(medico);
        return ResponseEntity.ok(updateMEdicos);
    }
    // Delete a Medico
    @DeleteMapping("/Medicos/{idMedico}")
    public ResponseEntity<Medico> deleteNote(@PathVariable(value = "idMedico") Long medicoId) {
        Medico medico = medicoService.findOne(medicoId);
        if(medico == null) {
            return ResponseEntity.notFound().build();
        }

        medicoService.delete(medico);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/Medicos", params = {"especial"})
    public List<Medico> listAll(Long especial) {
        List<Medico> paciente = medicoService.findByEspecial(especial);
        return paciente;
    }


}
