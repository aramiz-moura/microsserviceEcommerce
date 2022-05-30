package com.letscode.carrinhosapi.domain;



public class CarrinhoRequest {

    private String idUsuario;


    public CarrinhoRequest(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


}
