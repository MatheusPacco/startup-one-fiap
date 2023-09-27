package com.example.demospring.repository;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findAllByPacienteId(int id);
}
