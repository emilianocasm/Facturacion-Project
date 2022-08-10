package com.coderhouse.facturacion.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "factura")
public class Invoice {

    @Column(name= "ID_FACTURA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_invoice;

    @Column(name= "FECHA")
    private LocalDateTime date;

    @Column(name= "CANTIDAD")
    private Integer stock;

    @Column(name= "TOTAL")
    private Float total;

    @Column(name= "ID_CLIENTE")
    private Integer id_cliente;

}
