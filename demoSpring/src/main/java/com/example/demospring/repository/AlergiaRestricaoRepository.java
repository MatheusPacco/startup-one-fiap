package com.example.demospring.repository;

import com.example.demospring.model.AlergiaRestricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlergiaRestricaoRepository extends JpaRepository<AlergiaRestricao, Integer> {

    List<AlergiaRestricao> findByCodigo (int codigo);
    List<AlergiaRestricao> findByGravidade (String gravidade);
    List<AlergiaRestricao> findByTipo (String tipo);

}
