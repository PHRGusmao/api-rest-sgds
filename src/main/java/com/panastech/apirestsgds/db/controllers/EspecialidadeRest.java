package com.panastech.apirestsgds.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panastech.apirestsgds.Entidade.modelo.Especialidade;
import com.panastech.apirestsgds.db.respositorio.RepositorioEspecialidade;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeRest {
    @Autowired
    private RepositorioEspecialidade repositorioEspecialidade;

    @GetMapping
    public List<Especialidade> listar() {
        return repositorioEspecialidade.findAll();
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody List<Especialidade> especialidade) {
        for (Especialidade auto : especialidade) {
            repositorioEspecialidade.saveAll(especialidade);
        }
    }

}
