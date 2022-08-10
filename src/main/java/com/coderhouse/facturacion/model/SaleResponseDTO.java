package com.coderhouse.facturacion.model;

import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleResponseDTO {
    private LocalDateTime date;
    private Client client;
    private List<Sale> saleList;
    private Float total;
}
