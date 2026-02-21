package org.example.giaback.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.giaback.entities.MaterialType;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

    private Integer id;

    private String name;

    private MaterialType materialTypeId;

    private Double unitPrice;

    private Integer quantityInStock;

    private Integer minQuantity;

    private Integer quantityInPackage;

    private String Measurement;


}
