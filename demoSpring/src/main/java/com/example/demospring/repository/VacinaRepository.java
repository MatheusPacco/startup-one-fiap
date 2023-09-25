package com.example.demospring.repository;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {

    List<Vacina> findByNmVacina(String NmVacina);
    List<Vacina> findByProtecaoContra (String ProtecaoContra);
    List<Vacina> findByIdadeMax (int idadeMax);
    List<Vacina> findByIdadeMin (int idadeMin);
    List<Vacina> findByIdadeRecomendada (int idadeRecomendada);
}
