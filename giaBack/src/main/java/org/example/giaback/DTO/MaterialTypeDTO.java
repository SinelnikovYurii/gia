package org.example.giaback.DTO;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialTypeDTO {

    private Integer id;

    private String materialType;

    private Double losePercent;

}
