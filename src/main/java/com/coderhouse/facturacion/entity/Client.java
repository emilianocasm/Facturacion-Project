package com.coderhouse.facturacion.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "cliente", schema = "facturacion")
public class Client {

    @Id
    @Column(name= "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(name= "NOMBRE")
    private String name;

    @Column(name= "APELLIDO")
    private String surname;

    @Column(name= "EMAIL")
    private String email;

    @Column(name= "DNI")
    private Integer dni;
}
