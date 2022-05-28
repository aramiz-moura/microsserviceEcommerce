package com.letscode.usuariosapi.repository;

import com.letscode.usuariosapi.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
