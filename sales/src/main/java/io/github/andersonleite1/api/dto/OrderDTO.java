package io.github.andersonleite1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull(message = "{field.client-code.required}")
    private Integer client;

    @NotNull(message = "{field.order-total.required}")
    private BigDecimal total;

    @NotNull(message = "{field.order-items.required}")
    private List<ItemOrderDTO> items;
}
