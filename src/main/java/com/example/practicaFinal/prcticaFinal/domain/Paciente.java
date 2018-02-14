package com.example.practicaFinal.prcticaFinal.domain;

import javax.persistence. *;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paciente_id")
    private Long idPaciente;
    private Long dni;
    private String nombre;
    @Column(name = "e_mail")
    private String email;

    private Long telefono;
    @Column(name = "obra_social_id")
    private Long obraSocial;
    private String estado;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(Long obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
