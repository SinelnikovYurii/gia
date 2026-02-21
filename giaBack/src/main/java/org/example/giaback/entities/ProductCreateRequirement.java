package org.example.giaback.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_create_requirement")
public class ProductCreateRequirement {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, name = "id_product")
    private Integer productId;

    @Column(nullable = false, name = "id_material")
    private Integer materialId;

    @Column(nullable = false, name = "count_per_one")
    private Double countPerOne;


}
