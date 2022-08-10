package com.coderhouse.facturacion.controller;
import com.coderhouse.facturacion.model.SaleRequestDTO;
import com.coderhouse.facturacion.model.SaleResponseDTO;
import com.coderhouse.facturacion.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/venta")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public SaleResponseDTO createSale(@RequestBody SaleRequestDTO saleRequestDTO){
        /**
         * The createSale method will create a sale, and return a voucher with details.
         */
        return saleService.createSale(saleRequestDTO);
    }

}
