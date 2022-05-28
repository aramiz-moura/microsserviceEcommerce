package com.letscode.carrinhosapi.domain;




public class ItemPedido {

    private String usuarioId;
    private String produtoId;
    private Integer quantidade;

    public String getProdutoId() {
        return produtoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
