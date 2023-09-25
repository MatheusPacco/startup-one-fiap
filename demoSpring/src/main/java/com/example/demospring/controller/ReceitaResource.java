package com.example.demospring.controller;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Receita;
import com.example.demospring.repository.PacienteRepository;
import com.example.demospring.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receita")
public class ReceitaResource {

    @Autowired
    private ReceitaRepository receitaRepository;

    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<Receita>> listaReceitas() {
        List<Receita> pacientes = receitaRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    // Esse POST não consegue cadastrar o relacionamento com o cliente
    @PostMapping
    public ResponseEntity<Receita> cadastrarPaciente(@RequestBody Receita receita) {
        try{
            Paciente paciente = receitaRepository.findPacienteById(receita.getPaciente().getId());
            receita.setPaciente(paciente);
            Receita novaReceita = receitaRepository.save(receita);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaReceita);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(receita);
        }
    }

}
