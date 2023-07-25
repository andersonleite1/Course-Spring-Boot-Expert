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
    @NotEmpty(message = "{field.description.required}")
    @Column(name = "descricao")
    private String description;

    @Column(name = "preco_unitario")
    @NotEmpty(message = "{field.price.required}")
    private BigDecimal price;

}
