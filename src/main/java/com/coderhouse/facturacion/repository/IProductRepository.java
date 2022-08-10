package com.coderhouse.facturacion.repository;

import com.coderhouse.facturacion.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
