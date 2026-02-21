package org.example.giaback.controllers;

import org.example.giaback.DTO.MaterialDTO;
import org.example.giaback.DTO.ProductDTO;
import org.example.giaback.entities.Material;
import org.example.giaback.entities.Product;
import org.example.giaback.entities.Supplier;
import org.example.giaback.service.MaterialService;
import org.example.giaback.service.ProductService;
import org.hibernate.UnsupportedLockAttemptException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products != null) {
            List<ProductDTO> productDTOs = products.stream().map(product -> new ProductDTO(
                    product.getId(),
                    product.getArticle(),
                    product.getName(),
                    product.getDescription(),
                    product.getProductTypeId(),
                    product.getUnitPrice(),
                    product.getWeightWithoutPackage(),
                    product.getWeightWithPackage(),
                    product.getQuantityInStock(),
                    product.getMinQuantity(),
                    product.getTimeForCreate(),
                    product.getNumberOfPeopleInProduction(),
                    product.getQuantityInPackage(),
                    product.getMeasurement()
            )).toList();
            return ResponseEntity.ok(productDTOs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getArticle(),
                    product.getName(),
                    product.getDescription(),
                    product.getProductTypeId(),
                    product.getUnitPrice(),
                    product.getWeightWithoutPackage(),
                    product.getWeightWithPackage(),
                    product.getQuantityInStock(),
                    product.getMinQuantity(),
                    product.getTimeForCreate(),
                    product.getNumberOfPeopleInProduction(),
                    product.getQuantityInPackage(),
                    product.getMeasurement()
            );
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(Product product) {
        Product createdProduct = productService.createProduct(product);
        if(createdProduct == null) {
            return ResponseEntity.badRequest().build();
        }else{
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getArticle(),
                    product.getName(),
                    product.getDescription(),
                    product.getProductTypeId(),
                    product.getUnitPrice(),
                    product.getWeightWithoutPackage(),
                    product.getWeightWithPackage(),
                    product.getQuantityInStock(),
                    product.getMinQuantity(),
                    product.getTimeForCreate(),
                    product.getNumberOfPeopleInProduction(),
                    product.getQuantityInPackage(),
                    product.getMeasurement()
            );
            return ResponseEntity.ok(productDTO);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(Integer id, Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getArticle(),
                    product.getName(),
                    product.getDescription(),
                    product.getProductTypeId(),
                    product.getUnitPrice(),
                    product.getWeightWithoutPackage(),
                    product.getWeightWithPackage(),
                    product.getQuantityInStock(),
                    product.getMinQuantity(),
                    product.getTimeForCreate(),
                    product.getNumberOfPeopleInProduction(),
                    product.getQuantityInPackage(),
                    product.getMeasurement()
            );
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
