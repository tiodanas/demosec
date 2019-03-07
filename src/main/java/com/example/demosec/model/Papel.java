package com.example.demosec.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "papel")
public class Papel {

    @Id
//    @Column(name="id_papel")
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String role;
}
