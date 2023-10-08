package io.github.andersonleite1.domain.entity;

import io.github.andersonleite1.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    @Column(name = "data_pedido")
    private LocalDate dateOrder;

    @Column(name = "total", precision = 20, scale = 2)
    @NotEmpty(message = "{field.order-total.required}")
    private BigDecimal total;

    @OneToMany(mappedBy = "order")
    @NotEmpty(message = "{field.order-items.required}}")
    private List<ItemOrder> items;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
