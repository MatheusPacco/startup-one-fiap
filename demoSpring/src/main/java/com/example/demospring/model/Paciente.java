package com.example.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Paciente {

    @Id
    @SequenceGenerator(name="paciente", sequenceName = "SQ_PACIENTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
    @Column(name = "id_paciente")
    private int id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 120)
    @NotNull
    private String nome;

    @NotNull
    private int idade;

    @Column(unique=true, nullable = false) // Coluna de valor único
    @NotNull
    private String email;

    @Past
    private LocalDate dtCadastro;

    @OneToMany(mappedBy = "paciente")
    List<VacinaRealizada> vacinasRealizadas;

    // Doc sobre Cascade https://www.baeldung.com/jpa-cascade-types
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<HistoricoMedicamento> historicoMedicamentos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Receita> historicoReceitas;

    public Paciente(){}
    public Paciente(int id){
        this.id = id;
    }
    public Paciente(int id, String nome, int idade, String email, LocalDate dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.dtCadastro = dtCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public List<VacinaRealizada> getVacinasRealizadas() {
        return vacinasRealizadas;
    }

    public void setVacinasRealizadas(List<VacinaRealizada> vacinasRealizadas) {
        this.vacinasRealizadas = vacinasRealizadas;
    }
}
