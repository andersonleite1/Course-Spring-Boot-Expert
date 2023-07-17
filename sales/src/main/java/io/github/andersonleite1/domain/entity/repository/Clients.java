package io.github.andersonleite1.domain.entity.repository;

import io.github.andersonleite1.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clients {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "select * from cliente";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, new Object[]{
                client.getName()
        });
        return client;
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("nome");
                return new Client(id, name);
            }
        });
    }
}
