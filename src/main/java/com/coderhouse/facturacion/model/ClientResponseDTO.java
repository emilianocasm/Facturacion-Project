package com.coderhouse.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    private String name;
    private String surname;
    private Integer age;
}
