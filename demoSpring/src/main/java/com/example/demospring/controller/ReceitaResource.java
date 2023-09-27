package com.example.demospring.controller;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Receita;
import com.example.demospring.repository.PacienteRepository;
import com.example.demospring.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        }).orElseThrow(() -> new ResourceNotFoundException("Nenhum paciente foi encontrado com esse ID: " + idPaciente));

        return new ResponseEntity<>(receitaFinal, HttpStatus.CREATED);
    }

    @PutMapping("{id}/modificar")
    public ResponseEntity<Receita> modificarReceita(@PathVariable (value= "id") long id, @RequestBody Receita receita){
        if(receitaRepository.existsById(id)){
            Receita newReceita = receitaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar uma receita com esse id: " + id));

            if(receita.getDescricao() != null){
                newReceita.setDescricao(receita.getDescricao());
            }

            if(receita.getDataPrescricao() != null){
                newReceita.setDataPrescricao(receita.getDataPrescricao());
            }

            int idPaciente = receita.getPaciente().getId();
            if(idPaciente > 0 && pacienteRepository.existsById(idPaciente) && pacienteRepository.findById(idPaciente).isPresent()){
                Paciente paciente = pacienteRepository.findById(idPaciente).get();
                newReceita.setPaciente(paciente);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(receitaRepository.save(newReceita), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletarReceita(@PathVariable (value = "id") long id) {
        if(receitaRepository.existsById(id)){
            receitaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
