package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clients extends JpaRepository<Client, Integer> {

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Client> findByName(@Param("nome") String name);

    @Query(" delete from Client c where c.name = :nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByName(String name);

    @Query(" select c from Client c left join fetch c.orders where c.id = :id  ")
    Client findClientFetchOrders( @Param("id") Integer id );
}
