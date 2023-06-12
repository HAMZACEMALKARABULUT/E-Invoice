package com.izibiz.api.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public @Data class InvoiceDto implements Serializable {


    private long id;

    private long customerId;

    private double totalCost;

    private double totalTlCost;

    private double totalTax;

    private LocalDate createDate;

    private String createTime;

    private String moneyType;

    private String uuid;

    private String status;

    private Long userId;

    private List<InvoiceLineDto> invoiceLines;

}
