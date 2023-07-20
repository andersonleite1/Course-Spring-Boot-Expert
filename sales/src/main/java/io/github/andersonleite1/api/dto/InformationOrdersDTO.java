package io.github.andersonleite1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationOrdersDTO {
    private Integer code;
    private String cpf;
    private String clientName;
    private BigDecimal total;
    private String dateOrder;
    private String status;
    private List<InformationOrderItemDTO> items;
}
