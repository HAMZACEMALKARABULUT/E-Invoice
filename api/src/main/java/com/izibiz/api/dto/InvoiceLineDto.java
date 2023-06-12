package com.izibiz.api.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public @Data class InvoiceLineDto implements Serializable {



    private long id;

    private int piece;

    private Long invoiceId;

    private double lineCost;

    private double lineTaxCost;

    private ProductDto product;

}
