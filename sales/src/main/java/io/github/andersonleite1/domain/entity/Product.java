package io.github.andersonleite1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_produtos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Field description is required")
    @Column(name = "descricao")
    private String description;

    @NotEmpty(message = "Field price is required")
    @Column(name = "preco_unitario")
    private BigDecimal price;

}
