package org.example.giaback.repository;

import org.example.giaback.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypesRepository extends JpaRepository<ProductType, Integer> {
}
