package com.panastech.apirestsgds.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panastech.apirestsgds.Entidade.Usuario;
import com.panastech.apirestsgds.db.RepositorioUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @GetMapping
    public List<Usuario> listar(){
        return repositorioUsuario.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody List<Usuario> listUsuario){
        for(Usuario usuario: listUsuario){
            repositorioUsuario.save(usuario);
        }
    }

    @PutMapping
    public void alterar(@RequestBody List<Usuario> listUsuario){
        for(Usuario usuario: listUsuario){
            repositorioUsuario.save(usuario);
        }
    }

    @DeleteMapping
    public void delete(@RequestBody List<Usuario> listUsuario){
       for(Usuario usuario: listUsuario){
            repositorioUsuario.delete(usuario);
        }
    }
}
