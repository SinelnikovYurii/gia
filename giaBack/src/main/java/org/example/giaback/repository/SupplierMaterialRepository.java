package org.example.giaback.repository;

import org.example.giaback.entities.Material;
import org.example.giaback.entities.ProductType;
import org.example.giaback.entities.Supplier;
import org.example.giaback.entities.SupplierMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierMaterialRepository extends JpaRepository<SupplierMaterials, Integer> {

    List<SupplierMaterials> findBySupplierName(String name);

    List<SupplierMaterials> findByMaterialName(String materialName);


}
