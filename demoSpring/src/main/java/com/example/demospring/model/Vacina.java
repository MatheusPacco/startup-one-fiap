package com.example.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity

public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_vacina")
    private int cod;

    @NotBlank
    @Column(name="nm_vacina", length = 120)
    private String nmVacina;

    @NotBlank
    @Column(name="protecao_contra", length = 255)
    private String protecaoContra;

    @Column(name="num_doses", columnDefinition = "SMALLINT")
    private int numDoses;

    @Column(name="idade_recomendada", columnDefinition = "SMALLINT")
    private int idadeRecomendada;

    @Column(name="idade_min", columnDefinition = "SMALLINT")
    private int idadeMin;

    @Column(name="idade_max", columnDefinition = "SMALLINT")
    private int idadeMax;

    @Column(name="intervalo_doses", columnDefinition = "SMALLINT")
    private int intervaloDoses;

    @OneToMany(mappedBy = "vacina")
    List<VacinaRealizada> vacinasRealizadas;

    public Vacina() {

    }

    public Vacina(int cod, String nmVacina, String protecaoContra, int numDoses, int idadeRecomendada, int idadeMin, int idadeMax) {
        this.cod = cod;
        this.nmVacina = nmVacina;
        this.protecaoContra = protecaoContra;
        this.numDoses = numDoses;
        this.idadeRecomendada = idadeRecomendada;
        this.idadeMin = idadeMin;
        this.idadeMax = idadeMax;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNmVacina() {
        return nmVacina;
    }

    public void setNmVacina(String nmVacina) {
        this.nmVacina = nmVacina;
    }

    public String getProtecaoContra() {
        return protecaoContra;
    }

    public void setProtecaoContra(String protecaoContra) {
        this.protecaoContra = protecaoContra;
    }

    public int getNumDoses() {
        return numDoses;
    }

    public void setNumDoses(int numDoses) {
        this.numDoses = numDoses;
    }

    public int getIdadeRecomendada() {
        return idadeRecomendada;
    }

    public void setIdadeRecomendada(int idadeRecomendada) {
        this.idadeRecomendada = idadeRecomendada;
    }

    public int getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public void setIdadeMax(int idadeMax) {
        this.idadeMax = idadeMax;
    }

    public List<VacinaRealizada> getVacinasRealizadas() {
        return vacinasRealizadas;
    }

    public void setVacinasRealizadas(List<VacinaRealizada> vacinasRealizadas) {
        this.vacinasRealizadas = vacinasRealizadas;
    }

    public int getIntervaloDoses() {
        return intervaloDoses;
    }

    public void setIntervaloDoses(int intervaloDoses) {
        this.intervaloDoses = intervaloDoses;
    }
}
