package com.letscode.carrinhosapi.domain;




import java.util.HashMap;


public class CarrinhoResponse {
    private String usuarioId;
    private Boolean status;

    private HashMap<String,Integer> listaProdutos;

    public CarrinhoResponse(String usuarioId, Boolean status, HashMap<String, Integer> listaProdutos) {
        this.usuarioId = usuarioId;
        this.status = status;
        this.listaProdutos = listaProdutos;
    }

    public CarrinhoResponse(CarrinhoEntity carrinhoEntity) {
        this.usuarioId = carrinhoEntity.getUsuarioId();
        this.status = carrinhoEntity.getStatus();
        this.listaProdutos = carrinhoEntity.getListaProdutos();
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public HashMap<String, Integer> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(HashMap<String, Integer> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
