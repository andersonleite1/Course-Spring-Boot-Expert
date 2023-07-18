package io.github.andersonleite1.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "descricao")
    private String description;
    @Column(name = "preco_unitario")
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
