package com.letscode.carrinhosapi.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.HashMap;


@Document(collection = "carrinhos")
public class CarrinhoEntity {

    @Id
    private String id;

    private String usuarioId;
    private Boolean status;

    @Field
    private HashMap<String,Integer> listaProdutos;
    private BigDecimal precoFinal;


    public CarrinhoEntity(String usuarioId) {
        this.usuarioId = usuarioId;
        this.status = true;
        this.listaProdutos = new HashMap<>();
        this.precoFinal = BigDecimal.ZERO;
    }

    public BigDecimal getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(BigDecimal precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
