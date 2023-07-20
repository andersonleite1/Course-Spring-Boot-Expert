package io.github.andersonleite1.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationOrderItemDTO {
    private String productDescription;
    private BigDecimal priceUnity;
    private Integer quantity;
}
