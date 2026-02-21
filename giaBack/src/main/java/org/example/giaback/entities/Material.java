package org.example.giaback.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "material_type")
    private MaterialType materialType;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "min_quantity")
    private Integer minQuantity;

    @Column(name = "quantity_in_package")
    private Integer quantityInPackage;

    @Column(name = "measurement")
    private String Measurement;



}
