package com.example.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class AlergiaRestricao {

    @Id
    @SequenceGenerator(name = "alergia", sequenceName = "SQ_ALERGIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alergia")
    private int codigo;

    @NotBlank(message = "Alergia ou Restrição obrigatória!")
    @Size(max = 50)
    private String descricao;

    @NotBlank(message = "Tipo obrigatória!")
    @Size(max = 1)
    private String tipo; //tipo: A ou R, guardaria assim no bd

    @NotBlank(message = "Gravidade obrigatória!")
    @Size(max = 50)
    private String gravidade;

    @Size(max = 50)
    private String observacao;

    @CurrentTimestamp // Traz apenas a data normal sem hora, minutos ou segundos
    private LocalDate dataRegistro;

    public AlergiaRestricao() {
    }

    public AlergiaRestricao(int codigo, String descricao, String tipo, String gravidade, String observacao, LocalDate dataRegistro) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.gravidade = gravidade;
        this.observacao = observacao;
        this.dataRegistro = dataRegistro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
