package org.example.giaback.repository;

import org.example.giaback.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    List<Supplier> findAllByName(String supplierName);

    Supplier findByName(String supplierName);
}
