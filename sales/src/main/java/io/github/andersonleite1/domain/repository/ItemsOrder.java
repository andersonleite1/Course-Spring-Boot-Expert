package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsOrder extends JpaRepository<ItemOrder, Integer> {
}
