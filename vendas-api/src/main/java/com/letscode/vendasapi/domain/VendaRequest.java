package com.letscode.vendasapi.domain;



public class VendaRequest {

    private Integer usuarioId;

    public VendaRequest(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
