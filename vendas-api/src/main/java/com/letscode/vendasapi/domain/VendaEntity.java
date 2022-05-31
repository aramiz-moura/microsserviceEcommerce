package com.letscode.vendasapi.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Map;

@Document(collection = "vendas")
public class VendaEntity {

    @Id
    private String id;
    private Integer usuarioId;
    private String carrinhoId;
    private BigDecimal precoTotalFinal;

    @Field
    private Map<String,BigDecimal> produtos;



    public VendaEntity(VendaComCarrinhoRequest request) {
        this.usuarioId = request.getUsuarioId();
        this.carrinhoId = request.getId();
        this.precoTotalFinal = request.getPrecoTotal();
        this.produtos = request.getProdutos();
    }

    public VendaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(String carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public BigDecimal getPrecoTotalFinal() {
        return precoTotalFinal;
    }

    public void setPrecoTotalFinal(BigDecimal precoTotalFinal) {
        this.precoTotalFinal = precoTotalFinal;
    }

    public Map<String, BigDecimal> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<String, BigDecimal> produtos) {
        this.produtos = produtos;
    }
}
