package com.izibiz.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="User")
@Table(name="user")
public @Data class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="mail")
    private String mail;
    @Column (name="password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)


    @JoinTable(
            name="user_role",
            joinColumns=
            @JoinColumn(name="user_id", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="role_id", referencedColumnName="ID")
    )
    private List<RoleEntity> role;

}
