package com.izibiz.api.dto;

import lombok.Data;

import java.io.Serializable;

public @Data class InvoiceLineDto implements Serializable {



    private long id;

    private int piece;

    private Long invoiceId;

    private double lineCost;

    private double lineTaxCost;

    private ProductDto product;

}
