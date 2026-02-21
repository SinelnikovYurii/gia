package org.example.giaback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String article;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "id")
    private ProductType productTypeId;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "weight_without_package")
    private Double weightWithoutPackage;

    @Column(name = "weight_with_package")
    private Double weightWithPackage;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "min_quantity")
    private Integer minQuantity;

    @Column(name = "time_for_create")
    private Double timeForCreate;

    @Column(name = "number_of_people_in_production")
    private Integer numberOfPeopleInProduction;

    @Column(name = "quantity_in_package")
    private Integer quantityInPackage;

    @Column(name = "measurement")
    private String Measurement;

}
