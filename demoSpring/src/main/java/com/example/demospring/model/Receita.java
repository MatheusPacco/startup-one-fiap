package com.example.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Necessário inserir a descrição")
    private String descricao;

    @NotNull
    private LocalDate dataPrescricao;

    @ManyToOne
    @NotNull(message = "Necessário inserir um paciente válido")
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Receita() {

    }
    public Receita(Long id, String descricao, LocalDate dataPrescricao, Paciente paciente) {
        this.id = id;
        this.descricao = descricao;
        this.dataPrescricao = dataPrescricao;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}