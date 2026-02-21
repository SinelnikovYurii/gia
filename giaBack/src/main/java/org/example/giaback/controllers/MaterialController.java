package org.example.giaback.controllers;

import org.example.giaback.DTO.MaterialDTO;
import org.example.giaback.DTO.SupplierDTO;
import org.example.giaback.entities.Material;
import org.example.giaback.entities.Supplier;
import org.example.giaback.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;


    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }


    @GetMapping
    public ResponseEntity<List<MaterialDTO>> getAllMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        if (materials != null) {
            List<MaterialDTO> materialDTOs = materials.stream().map(material -> new MaterialDTO(
                    material.getId(),
                    material.getName(),
                    material.getMaterialType(),
                    material.getUnitPrice(),
                    material.getQuantityInStock(),
                    material.getMinQuantity(),
                    material.getQuantityInPackage(),
                    material.getMeasurement()
            )).toList();
            return ResponseEntity.ok(materialDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/material/{materialId}")
    public ResponseEntity<List<SupplierDTO>> getAllSuppliersByMaterialName(String materialName) {
        List<Supplier> suppliers = materialService.getAllSuppliersByMaterialName(materialName);
        if (suppliers != null) {
            List<SupplierDTO> supplierDTOs = suppliers.stream().map(supplier -> new SupplierDTO(
                    supplier.getId(),
                    supplier.getName(),
                    supplier.getInn(),
                    supplier.getType(),
                    supplier.getRating()
            )).toList();
            return ResponseEntity.ok(supplierDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<MaterialDTO>> getAllMaterialsBySupplierId(String supplierName) {
        List<Material> materials = materialService.getAllMaterialsBySupplierName(supplierName);
        if (materials != null) {
            List<MaterialDTO> materialDTOs = materials.stream().map(material -> new MaterialDTO(
                    material.getId(),
                    material.getName(),
                    material.getMaterialType(),
                    material.getUnitPrice(),
                    material.getQuantityInStock(),
                    material.getMinQuantity(),
                    material.getQuantityInPackage(),
                    material.getMeasurement()
            )).toList();
            return ResponseEntity.ok(materialDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> getMaterialById(Integer id) {
        Material material = materialService.getMaterialById(id);
        if (material != null) {
            MaterialDTO materialDTO = new MaterialDTO(
                    material.getId(),
                    material.getName(),
                    material.getMaterialType(),
                    material.getUnitPrice(),
                    material.getQuantityInStock(),
                    material.getMinQuantity(),
                    material.getQuantityInPackage(),
                    material.getMeasurement()
            );
            return ResponseEntity.ok(materialDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<MaterialDTO> createMaterial(Material material) {
        Material createdMaterial = materialService.createMaterial(material);
        if(createdMaterial == null) {
            return ResponseEntity.badRequest().build();
        }else{
            MaterialDTO materialDTO = new MaterialDTO(
                    createdMaterial.getId(),
                    createdMaterial.getName(),
                    createdMaterial.getMaterialType(),
                    createdMaterial.getUnitPrice(),
                    createdMaterial.getQuantityInStock(),
                    createdMaterial.getMinQuantity(),
                    createdMaterial.getQuantityInPackage(),
                    createdMaterial.getMeasurement()
            );
            return ResponseEntity.ok(materialDTO);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<MaterialDTO> updateMaterial(Integer id, Material material) {
        Material updatedMaterial = materialService.updateMaterial(id, material);
        if (updatedMaterial != null) {
                MaterialDTO materialDTO = new MaterialDTO(
                        updatedMaterial.getId(),
                        updatedMaterial.getName(),
                        updatedMaterial.getMaterialType(),
                        updatedMaterial.getUnitPrice(),
                        updatedMaterial.getQuantityInStock(),
                        updatedMaterial.getMinQuantity(),
                        updatedMaterial.getQuantityInPackage(),
                        updatedMaterial.getMeasurement()
                );
            return ResponseEntity.ok(materialDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
