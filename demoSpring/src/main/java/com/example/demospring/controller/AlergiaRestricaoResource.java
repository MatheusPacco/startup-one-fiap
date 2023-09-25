package com.example.demospring.controller;

import com.example.demospring.model.AlergiaRestricao;
import com.example.demospring.repository.AlergiaRestricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alergia_restricao")
public class AlergiaRestricaoResource {

    @Autowired
    private AlergiaRestricaoRepository alergiaRestricaoRepository;

    @GetMapping
    public List<AlergiaRestricao> listar() {
        return alergiaRestricaoRepository.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public AlergiaRestricao cadastrar(@RequestBody AlergiaRestricao alergia) {
        return alergiaRestricaoRepository.save(alergia);
    }

    // Não consegui resolver esse
    // Basicamente é necessário que a entidade trazida da requisição, tenha os mesmo valores que a entidade
    // presente no BD, não consegui mesclar ambas as entetidades.
    @PutMapping("{id}")
    public AlergiaRestricao atualizar(@RequestBody AlergiaRestricao alergia, @PathVariable int id) {
        if(alergiaRestricaoRepository.findById(id).isPresent()){
            AlergiaRestricao updateAlergiaRestricao = alergiaRestricaoRepository.findById(id).get();
            updateAlergiaRestricao.setDescricao(alergia.getDescricao());
            updateAlergiaRestricao.setTipo(alergia.getTipo());
            updateAlergiaRestricao.setGravidade(alergia.getGravidade());
            updateAlergiaRestricao.setObservacao(alergia.getObservacao());

            return alergiaRestricaoRepository.save(updateAlergiaRestricao);
        }else {
            return null;
        }
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        alergiaRestricaoRepository.deleteById(codigo);
    }

}
