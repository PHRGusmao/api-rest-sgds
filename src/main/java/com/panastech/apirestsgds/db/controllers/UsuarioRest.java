package com.panastech.apirestsgds.db.controllers;

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

    @GetMapping("/buscaruserid/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarusercpf/{cpf}")
    public ResponseEntity<Usuario> getUsuarioByCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = repositorioUsuario.findByCpf(cpf);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarusernome/{nome}")
    public ResponseEntity<List<Usuario>> getUsuarioByNome(@PathVariable String nome) {
        List<Usuario> usuario = repositorioUsuario.findByNomeContaining(nome);
        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/buscaruseremail/{email}")
    public ResponseEntity<List<Usuario>> getUsuarioByEmail(@PathVariable String email) {
        List<Usuario> usuario = repositorioUsuario.findByEmailContaining(email);
        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/buscarusertelefone/{telefone}")
    public ResponseEntity<List<Usuario>> getUsuarioByTelefone(@PathVariable String telefone) {
        List<Usuario> usuario = repositorioUsuario.findByTelefoneContaining(telefone);
        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/buscarusercargo/{cargo}")
    public ResponseEntity<List<Usuario>> getUsuarioByCargo(@PathVariable String cargo) {
        List<Usuario> usuario = repositorioUsuario.findByCargoContaining(cargo);
        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @PostMapping("/adicionarUsuario")
    public void salvar(@RequestBody List<Usuario> listUsuario) {
        for (Usuario usuario : listUsuario) {
            repositorioUsuario.save(usuario);
        }
    }

    @PutMapping("/alterarUsuario/{cpf}")
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
