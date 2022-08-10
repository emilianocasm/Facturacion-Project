package com.coderhouse.facturacion.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "producto")
public class Product {

    @Id
    @Column(name= "ID_PRODUCTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product;

    @Column(name= "DESCRIPCION")
    private String description;

    @Column(name= "CANTIDAD")
    private Integer stock;

    @Column(name= "PRECIO")
    private Float price;
}

