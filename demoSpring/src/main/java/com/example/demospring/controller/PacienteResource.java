package com.example.demospring.controller;

import com.example.demospring.model.Paciente;
import com.example.demospring.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

//List status code https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente") // Préfixo URL
public class PacienteResource {

    // Anotação para a injeção do EntityManager
    // Doc Adicicional: https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired.html
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("hellou")
    private String hellou(){
        return "<h1> Salve FML HELLOU WORLD </h1>";
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @ResponseStatus(code = HttpStatus.FOUND)
    @GetMapping("{id}")
    public Paciente buscar(@PathVariable int id) {
        // if(pacienteRepository.findById(id).isPresent()){
            return pacienteRepository.findById(id).get();
        // }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody Paciente paciente) {
        try{
            if(paciente.getIdade() == 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            pacienteRepository.save(paciente);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("{id}")
    public Paciente atualizar(@RequestBody Paciente paciente, @PathVariable int id) {
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        pacienteRepository.deleteById(id);

    }

    // Consegui realizar a requisição, seguindo o padrão
    // Final da URL de envio: ENDPOINT?VAR=VALOR & VAR=VALOR
    @GetMapping("pesquisa")
    public List<Paciente> buscar(@RequestParam(required = true) String nome, @RequestParam(required = false) String email) {
        System.out.print(nome);
        return email != null ? pacienteRepository.findByNomeAndAndEmail(nome, email) : pacienteRepository.findByNome(nome);
    }
}
