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
@Table(name = "supplier_materials")
public class SupplierMaterials {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @JoinColumn(nullable = false, name = "material_name")
    private String supplierName;

    @JoinColumn(nullable = false, name = "supplier_name")
    private String materialName;


}
