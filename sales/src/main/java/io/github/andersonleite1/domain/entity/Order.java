package io.github.andersonleite1.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;
    @Column(name = "data_pedido")
    private LocalDate dateOrder;
    @Column(length = 20, precision = 2)
    private BigDecimal total;
    @OneToMany(mappedBy = "order")
    @JoinColumn(name = "item_id")
    private List<ItemOrder> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemOrder> getItems() {
        return items;
    }

    public void setItems(List<ItemOrder> items) {
        this.items = items;
    }
}
