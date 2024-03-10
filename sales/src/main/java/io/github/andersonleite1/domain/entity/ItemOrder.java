package io.github.andersonleite1.domain.entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_items_pedido")
public class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Product product;

    @Column(name = "quantidade")
    @NotNull(message = "{field.quantity.not-null}")
    private Integer quantity;

}
