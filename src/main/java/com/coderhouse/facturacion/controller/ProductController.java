package com.coderhouse.facturacion.controller;

import com.coderhouse.facturacion.entity.Client;
import com.coderhouse.facturacion.entity.Product;
import com.coderhouse.facturacion.model.ClientSearch;
import com.coderhouse.facturacion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProduct();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Integer id ,@RequestBody Product product){
        /**
         * The updateProduct method will update a Product. It can update stock, description or price.
         */
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProducto(id);
    }

}
