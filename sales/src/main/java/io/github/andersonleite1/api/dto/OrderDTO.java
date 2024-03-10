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
    @NotNull(message = "{field.client.not-null}")
    private Integer client;

    @NotNull(message = "{field.total.not-null}")
    private BigDecimal total;

    @NotEmptyList(message = "{field.items.not-empty}")
    private List<ItemOrderDTO> items;
}
