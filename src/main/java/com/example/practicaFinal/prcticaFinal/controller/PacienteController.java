package com.example.practicaFinal.prcticaFinal.controller;


import com.example.practicaFinal.prcticaFinal.domain.Paciente;
import com.example.practicaFinal.prcticaFinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation. *;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    //Get All Pacientes
    @GetMapping("/Pacientes")
    public List<Paciente> getAllPacientes(){
        return pacienteRepository.findAll();
    }
    //Get a Paciente by ID
    @GetMapping("/Pacientes/{idPaciente}")
    public ResponseEntity<Paciente> getPacientesById(@PathVariable(value = "idPaciente") Long pacienteId) {
        Paciente paciente = pacienteRepository.findOne(pacienteId);
        if(paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(paciente);
    }
    //Create a new Pacientes
    @PostMapping("/Pacientes")
    public Paciente createPacientes(@Valid @RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/Pacientes/{idPaciente}")
    public ResponseEntity<Paciente> updateMedicos(@PathVariable(value = "idPaciente") Long pacienteId,
                                                   @Valid @RequestBody Paciente pacienteDetails) {
        Paciente paciente = pacienteRepository.findOne(pacienteId);
        if(paciente == null) {
            return ResponseEntity.notFound().build();
        }
        paciente.setDni(pacienteDetails.getDni());
        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setEmail(pacienteDetails.getEmail());
        paciente.setTelefono(pacienteDetails.getTelefono());
        paciente.setObraSocial(pacienteDetails.getObraSocial());
        paciente.setEstado(pacienteDetails.getEstado());
        paciente.setFechaCreacion(pacienteDetails.getFechaCreacion());


        Paciente updatePacientes=pacienteRepository.save(paciente);
        return ResponseEntity.ok(updatePacientes);


    }
    // Delete a Medico
    @DeleteMapping("/Pacientes/{idPaciente}")
    public ResponseEntity<Paciente> deleteNote(@PathVariable(value = "idPaciente") Long pacienteId) {
        Paciente paciente = pacienteRepository.findOne(pacienteId);
        if(paciente == null) {
            return ResponseEntity.notFound().build();
        }

        pacienteRepository.delete(paciente);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/Pacientes", params = {"obraSocial"})
    public List<Paciente> listAll(Long obraSocial) {
        List<Paciente> paciente = pacienteRepository.findByObraSocial(obraSocial);
        return paciente;
    }



}
