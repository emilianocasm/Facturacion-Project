package com.coderhouse.facturacion.model;

import com.coderhouse.facturacion.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SaleRequestDTO {
    private Integer userId;
    private List<Sale> detailSale;
}
