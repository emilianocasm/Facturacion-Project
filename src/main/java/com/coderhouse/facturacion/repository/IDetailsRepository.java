package com.coderhouse.facturacion.repository;

import com.coderhouse.facturacion.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailsRepository extends JpaRepository<Sale, Integer> {
}
