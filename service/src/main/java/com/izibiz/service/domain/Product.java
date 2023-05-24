package com.izibiz.service.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString(includeFieldNames = true)
public @Data class Product implements Serializable {
    private Long id;
    private String name;
    private String barcode;
    private Double unitPrice;//birim fiyat
    private Double quantity;//miktar
    private String unit;
    private Short vatRate;//(varsayılan kdv oranı)
    private String brand;
    private Long userId;

}
