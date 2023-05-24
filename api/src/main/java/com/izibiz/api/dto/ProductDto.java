package com.izibiz.api.dto;

import lombok.Data;

import java.io.Serializable;

public @Data class ProductDto implements Serializable {
    private Long id;
    private String name;
    private String barcode;
    private Double unitPrice;//birim fiyat
    private Double quantity;//miktar
    private String unit;
    private Short vatRate;//(varsayılan kdv oranı)
    private String brand;
    private  Long userId;

}
