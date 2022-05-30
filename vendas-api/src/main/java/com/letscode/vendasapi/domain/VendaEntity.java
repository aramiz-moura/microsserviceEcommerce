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
}
