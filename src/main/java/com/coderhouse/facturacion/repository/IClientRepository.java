package com.coderhouse.facturacion.repository;

import com.coderhouse.facturacion.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Integer> {
}
