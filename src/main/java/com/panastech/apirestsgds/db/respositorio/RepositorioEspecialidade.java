package com.panastech.apirestsgds.db.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panastech.apirestsgds.Entidade.modelo.Especialidade;
import java.util.List;
import java.util.Optional;

public interface RepositorioEspecialidade extends JpaRepository<Especialidade, Long> {
    Optional<Especialidade> findById(Long id);
}
