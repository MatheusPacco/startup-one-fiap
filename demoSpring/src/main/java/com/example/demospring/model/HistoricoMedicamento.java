package com.example.demospring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistoricoMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicamento;
    private LocalDate dataRetirada;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public HistoricoMedicamento() {

    }

    public HistoricoMedicamento(Long id, String medicamento, LocalDate dataRetirada, Paciente paciente) {
        this.id = id;
        this.medicamento = medicamento;
        this.dataRetirada = dataRetirada;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}