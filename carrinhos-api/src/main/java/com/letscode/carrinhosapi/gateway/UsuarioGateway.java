package com.letscode.carrinhosapi.gateway;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioGateway {

    private final RestTemplate restTemplate;

    public UsuarioGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> getUsuario(Integer usuarioId) {

        String url = String.format("http://usuariosAPI:8080/v1/usuario/%s", usuarioId);
        return restTemplate.getForEntity(url,String.class);
    }
}
