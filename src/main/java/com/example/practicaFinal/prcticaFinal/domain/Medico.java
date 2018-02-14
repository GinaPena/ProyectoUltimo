package com.example.practicaFinal.prcticaFinal.domain;
import javax.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "medico_id")
    private Long idMedico;
    private String nombre;
    @Column(name= "especialidad_id")
    private long especial;
    private String estado;

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getEstado() {
        return estado;
    }

    public long getEspecial() {
        return especial;
    }

    public void setEspecial(long especial) {
        this.especial = especial;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
