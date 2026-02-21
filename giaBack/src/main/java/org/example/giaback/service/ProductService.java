package org.example.giaback.service;


import org.example.giaback.entities.Material;
import org.example.giaback.entities.Product;
import org.example.giaback.repository.ProductRepository;
import org.example.giaback.repository.ProductTypesRepository;
import org.example.giaback.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypesRepository productTypesRepository;


    public ProductService(ProductRepository productRepository, ProductTypesRepository productTypesRepository) {
        this.productRepository = productRepository;
        this.productTypesRepository = productTypesRepository;

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

}
