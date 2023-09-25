package com.example.demospring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class VacinaRealizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina_realizada")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "cod_vacina")
    Vacina vacina;

    @Column(name = "dt_atendimento")
    private LocalDate dtAtendimento;

    @Column(name = "foi_atendido", columnDefinition = "Boolean")
    private boolean foiAtendido;


}
