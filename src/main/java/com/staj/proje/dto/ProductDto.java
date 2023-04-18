package com.staj.proje.dto;

import lombok.Data;

import java.io.Serializable;

public @Data class ProductDto implements Serializable {
    private long id;
    private String name;
    private String barcode;
    private double unitPrice;//birim fiyat
    private double quantity;//miktar
    private String unit;
    private short vatRate;//(varsayılan kdv oranı)
    private String brand;
}
