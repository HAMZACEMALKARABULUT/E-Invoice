package com.staj.proje.entity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Product")
@Table(name="product")
@ToString(includeFieldNames = true)
public @Data class Product implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="barcode")
    private String barcode;
    @Column(name="unit_price")
    private double unitPrice;//birim fiyat
    @Column(name="quantity")
    private double quantity;//miktar
    @Column(name="unit")
    private String unit;
    @Column(name="vat_rate")
    private short vatRate;//(varsayılan kdv oranı)
    @Column(name="brand")
    private String brand;

    @Column(name="user_id")
    private Long userId;

}
