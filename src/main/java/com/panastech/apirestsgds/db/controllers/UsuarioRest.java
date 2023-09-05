package com.panastech.apirestsgds.db.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panastech.apirestsgds.Entidade.Usuario;
import com.panastech.apirestsgds.Entidade.UsuarioDTO;
import com.panastech.apirestsgds.db.RepositorioUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @GetMapping
    public List<Usuario> listar() {
        return repositorioUsuario.findAll();
    }

    @GetMapping("/id:{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cpf:{cpf}")
    public ResponseEntity<Usuario> getUsuarioByCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = repositorioUsuario.findByCpf(cpf);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome:{nome}")
    public ResponseEntity<List<UsuarioDTO>> getUsuarioByNome(@PathVariable String nome) {
        List<Usuario> usuarios = repositorioUsuario.findByNomeContaining(nome);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setCpf(usuario.getCpf());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setTelefone(usuario.getTelefone());
            usuarioDTO.setCargo(usuario.getCargo());
            usuariosDTO.add(usuarioDTO);
        }

        if (usuariosDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuariosDTO);
        }
    }

    @GetMapping("/email:{email}")
    public ResponseEntity<List<UsuarioDTO>> getUsuarioByEmail(@PathVariable String email) {
        List<Usuario> usuarios = repositorioUsuario.findByEmailContaining(email);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setCpf(usuario.getCpf());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setTelefone(usuario.getTelefone());
            usuarioDTO.setCargo(usuario.getCargo());
            usuariosDTO.add(usuarioDTO);
        }

        if (usuariosDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuariosDTO);
        }
    }

    @GetMapping("/telefone:{telefone}")
    public ResponseEntity<List<UsuarioDTO>> getUsuarioByTelefone(@PathVariable String telefone) {
        List<Usuario> usuarios = repositorioUsuario.findByTelefoneContaining(telefone);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setCpf(usuario.getCpf());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setTelefone(usuario.getTelefone());
            usuarioDTO.setCargo(usuario.getCargo());
            usuariosDTO.add(usuarioDTO);
        }

        if (usuariosDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuariosDTO);
        }
    }

    @GetMapping("/cargo:{cargo}")
    public ResponseEntity<List<UsuarioDTO>> getUsuarioByCargo(@PathVariable String cargo) {
        List<Usuario> usuarios = repositorioUsuario.findByCargoContaining(cargo);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setCpf(usuario.getCpf());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setTelefone(usuario.getTelefone());
            usuarioDTO.setCargo(usuario.getCargo());
            usuariosDTO.add(usuarioDTO);
        }

        if (usuariosDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuariosDTO);
        }
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody List<Usuario> listUsuario) {
        for (Usuario usuario : listUsuario) {
            repositorioUsuario.save(usuario);
        }
    }

    @PutMapping("/alterar/cpf:{cpf}")
    public ResponseEntity<Usuario> alterarUsuarioByCpf(@PathVariable String cpf,
            @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = repositorioUsuario.findByCpf(cpf);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setCpf(usuarioAtualizado.getCpf());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setTelefone(usuarioAtualizado.getTelefone());
            usuario.setCargo(usuarioAtualizado.getCargo());

            usuarioAtualizado = repositorioUsuario.save(usuario);
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public void delete(@RequestBody List<Usuario> listUsuario) {
        for (Usuario usuario : listUsuario) {
            repositorioUsuario.delete(usuario);
        }
    }
}
