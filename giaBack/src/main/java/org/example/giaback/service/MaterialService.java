package org.example.giaback.service;

import org.example.giaback.entities.Material;
import org.example.giaback.entities.Supplier;
import org.example.giaback.entities.SupplierMaterials;
import org.example.giaback.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialTypeRepository materialTypeRepository;
    private final SupplierRepository supplierRepository;
    private final SupplierMaterialRepository supplierMaterialRepository;


    public MaterialService(MaterialRepository materialRepository, MaterialTypeRepository materialTypeRepository, SupplierRepository supplierRepository, SupplierMaterialRepository supplierMaterialRepository) {
        this.materialRepository = materialRepository;
        this.materialTypeRepository = materialTypeRepository;
        this.supplierRepository = supplierRepository;
        this.supplierMaterialRepository = supplierMaterialRepository;
    }

    public List<Material> getAllMaterialsBySupplierName(String name) {

        List<SupplierMaterials> supplierMaterials = supplierMaterialRepository.findBySupplierName(name);

        return supplierMaterials.stream()
                .map(supplierMaterial -> materialRepository.findByName(supplierMaterial.getMaterialName()))
                .toList();
    }

    public List<Supplier> getAllSuppliersByMaterialName(String name) {

        List<SupplierMaterials> supplierMaterials = supplierMaterialRepository.findByMaterialName(name);

        return supplierMaterials.stream()
                .map(supplierMaterial -> supplierRepository.findByName(supplierMaterial.getSupplierName()))
                .toList();
    }




    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Material getMaterialById(Integer id) {
        return materialRepository.findById(id).orElse(null);
    }

    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    public Material updateMaterial(Integer id, Material material) {
        if (materialRepository.existsById(id)) {
            material.setId(id);
            return materialRepository.save(material);
        } else {
            return null;
        }
    }



}
