package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Products extends JpaRepository<Product, Integer> {
}
