package io.github.andersonleite1.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome", length = 100)
    private String name;
    @OneToMany(mappedBy = "client")
    @JoinColumn(name = "perdido_id")
    private Set<Order> orders;

    public Client() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
