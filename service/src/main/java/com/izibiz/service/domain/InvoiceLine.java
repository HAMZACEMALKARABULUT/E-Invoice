package com.izibiz.service.domain;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;



@ToString(includeFieldNames = true)
public @Data class InvoiceLine implements Serializable {
    private long id;
    private int piece;
    private Long invoiceId;
    private double lineCost;
    private double lineTaxCost;
    private Product product;



}
