package io.github.andersonleite1.api.dto;

import io.github.andersonleite1.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull(message = "Enter client code")
    private Integer client;

    @NotNull(message = "Enter total order")
    private BigDecimal total;

    @NotEmptyList(message = "Enter with items of orders")
    private List<ItemOrderDTO> items;
}
