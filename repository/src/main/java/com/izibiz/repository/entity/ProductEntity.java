package com.izibiz.repository.entity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Product")
@Table(name="product")
@ToString(includeFieldNames = true)
public @Data class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="barcode")
    private String barcode;
    @Column(name="unit_price")
    private Double unitPrice;//birim fiyat
    @Column(name="quantity")
    private Double quantity;//miktar
    @Column(name="unit")
    private String unit;
    @Column(name="vat_rate")
    private Short vatRate;//(varsayılan kdv oranı)
    @Column(name="brand")
    private String brand;

    @Column(name="user_id")
    private Long userId;

}
