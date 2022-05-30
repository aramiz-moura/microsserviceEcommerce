package com.letscode.carrinhosapi.domain;




public class ItemPedido {

    private Integer usuarioId;
    private String produtoId;
    private Integer quantidade;

    public String getProdutoId() {
        return produtoId;
    }


    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
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
