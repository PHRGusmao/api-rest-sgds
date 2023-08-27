package com.panastech.apirestsgds.db;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.panastech.apirestsgds.Entidade.Usuario;


public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findByNomeContaining(String nome);

    List<Usuario> findByEmailContaining(String email);

    List<Usuario> findByTelefoneContaining(String telefone);

    List<Usuario> findByCargoContaining(String cargo);
}
