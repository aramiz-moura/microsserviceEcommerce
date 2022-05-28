package com.letscode.usuariosapi.service;


import com.letscode.usuariosapi.domain.UsuarioEntity;
import com.letscode.usuariosapi.domain.UsuarioRequest;
import com.letscode.usuariosapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioEntity salvaEntity(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity getPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário nao encontrado"));
    }


    public UsuarioEntity toEntity(UsuarioRequest request) {
        return new UsuarioEntity(
                request.getNome(),
                request.getNomeUsuario(),
                request.getEmail(),
                ZonedDateTime.now(),
                ZonedDateTime.now()
        );
    }

}
