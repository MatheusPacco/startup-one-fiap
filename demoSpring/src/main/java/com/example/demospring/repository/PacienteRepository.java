package com.example.demospring.repository;

import com.example.demospring.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

// Os métodos listados, são injeções especiais derivadas do JPARepository
// O clássico CRUD já é mapeado e injetado nessa interface pelo JpaRepository

// Mais sobre
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByNome(String prod);
    List<Paciente> findByEmail(String Email);
    List<Paciente> findByNomeAndAndEmail (String nome, String email);
    List<Paciente> findByIdadeGreaterThan(int idade);
}
