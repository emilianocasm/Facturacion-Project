package com.coderhouse.facturacion.repository;

import com.coderhouse.facturacion.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
    //Invoice findFirstByOrderByIdDesc();

    @Query(value = "SELECT LAST_INSERT_ID (id_factura) FROM factura ORDER BY 1 DESC LIMIT 1", nativeQuery=true)
    Integer getLastRecord();
}
