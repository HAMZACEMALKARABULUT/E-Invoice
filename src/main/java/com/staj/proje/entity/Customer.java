package com.staj.proje.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Customer")
@Table(name = "customer")
@ToString(includeFieldNames = true)
public @Data class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "tel_no")
    private String telNo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "tax_administration")
    private String taxAdministration;
    @Column(name = "title")
    private String title;
    @Column(name="user_id")
    private Long userId;
}

