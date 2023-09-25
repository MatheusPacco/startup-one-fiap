package com.example.demospring.controller;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Receita;
import com.example.demospring.repository.PacienteRepository;
import com.example.demospring.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("receita")
public class ReceitaResource {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<Receita>> listaReceitas() {
        List<Receita> pacientes = receitaRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    // Esse POST não consegue cadastrar o relacionamento com o cliente
    @PostMapping("{paciente}/cadastrarReceita")
    public ResponseEntity<Receita> cadastrarReceita(@PathVariable (value = "paciente") int idPaciente, @RequestBody Receita receita) {
        Receita receitaFinal = pacienteRepository.findById(idPaciente).map(paciente -> {
            receita.setPaciente(paciente);
            return receitaRepository.save(receita);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id"));

        return new ResponseEntity<>(receitaFinal, HttpStatus.CREATED);
    }
}
