package io.github.andersonleite1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderDTO {
    private Integer product;
    private Integer quantity;
}
