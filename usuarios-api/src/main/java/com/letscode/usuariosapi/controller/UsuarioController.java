package com.letscode.usuariosapi.controller;


import com.letscode.usuariosapi.domain.UsuarioEntity;
import com.letscode.usuariosapi.domain.UsuarioRequest;
import com.letscode.usuariosapi.domain.UsuarioResponse;
import com.letscode.usuariosapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<UsuarioResponse> criaUsuario(@RequestBody UsuarioRequest request) {
        UsuarioEntity entity = usuarioService.toEntity(request);
        usuarioService.salvaEntity(entity);
        return new ResponseEntity<>(new UsuarioResponse(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> getUsuarioPorId(@PathVariable Integer idUsuario) {
        UsuarioEntity entity = usuarioService.getPorId(idUsuario);
        return new ResponseEntity<>(new UsuarioResponse(entity),HttpStatus.ACCEPTED);
    }

}
