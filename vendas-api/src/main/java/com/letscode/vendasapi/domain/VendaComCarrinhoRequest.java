package com.letscode.vendasapi.domain;


import java.math.BigDecimal;
import java.util.Map;

public class VendaComCarrinhoRequest {
    private String id;
    private Integer usuarioId;
    private Boolean status;
    private BigDecimal precoTotal;
    private Map<String, BigDecimal> produtos;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Map<String, BigDecimal> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<String, BigDecimal> produtos) {
        this.produtos = produtos;
    }
}
