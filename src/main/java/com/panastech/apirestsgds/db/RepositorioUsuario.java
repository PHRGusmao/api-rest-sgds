package com.panastech.apirestsgds.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panastech.apirestsgds.Entidade.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
    
}
