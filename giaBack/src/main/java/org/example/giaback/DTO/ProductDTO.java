package org.example.giaback.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.giaback.entities.ProductType;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer id;

    private String name;

    private String article;

    private String description;

    private ProductType productTypeId;

    private Double unitPrice;

    private Double weightWithoutPackage;

    private Double weightWithPackage;

    private Integer quantityInStock;

    private Integer minQuantity;

    private Double timeForCreate;

    private Integer numberOfPeopleInProduction;

    private Integer quantityInPackage;

    private String Measurement;
}
