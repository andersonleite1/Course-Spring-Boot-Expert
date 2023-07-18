package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clients extends JpaRepository<Client, Integer> {
    List<Client> findByNameLike(String name);
}
