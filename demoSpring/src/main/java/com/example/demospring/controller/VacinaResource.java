package com.example.demospring.controller;

import com.example.demospring.model.Paciente;
import com.example.demospring.model.Vacina;
import com.example.demospring.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vacina")
public class VacinaResource {

    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping
    private List<Vacina> listar() { return vacinaRepository.findAll(); }

    @PostMapping("cadastrar")
    private Vacina cadastrarVacina(@Valid @RequestBody Vacina vacina) {
        try{
            return vacinaRepository.save(vacina);
        } catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("{cod}")
    public void deletar(@PathVariable int cod) {
        vacinaRepository.deleteById(cod);
    }

    @PutMapping("{id}")
    public Vacina atualizar(@RequestBody Vacina vacina, @PathVariable int cod) {
        vacina.setCod(cod);
        return vacinaRepository.save(vacina);
    }

}
