package io.github.andersonleite1.domain.repository;

import io.github.andersonleite1.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clients extends JpaRepository<Client, Integer> {

    List<Client> findByNameLike(String name );

//    @Query(value = "select c from Client c where c.name like :name")
//    List<Client> findByNameLike( @Param("name") String name );
}
