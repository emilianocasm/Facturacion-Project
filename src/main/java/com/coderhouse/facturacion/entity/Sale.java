package com.coderhouse.facturacion.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "detalle")
public class Sale {

    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "DESCRIPCION")
    private String description;

    @Column(name= "CANTIDAD")
    private Integer stock;

    @Column(name= "PRECIO")
    private Float price;

    @Column(name= "ID_FACTURA")
    private Integer id_invoice;

    @Column(name= "ID_PRODUCTO")
    private Integer id_product;
}
