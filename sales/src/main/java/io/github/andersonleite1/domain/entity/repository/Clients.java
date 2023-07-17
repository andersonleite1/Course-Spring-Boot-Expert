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
    private static String SELECT_BY_NAME = "select * from cliente where nome like ?";
    private static String SELECT_ALL = "select * from cliente";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, new Object[]{
                client.getName()
        });
        return client;
    }

    private static RowMapper<Client> getClientRowMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("nome");
                return new Client(id, name);
            }
        };
    }

    public List<Client> getByName(String name) {
        return jdbcTemplate.query(SELECT_BY_NAME, new Object[]{
            "%" + name + "%"
        }, getClientRowMapper());
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(SELECT_ALL, getClientRowMapper());
    }

    public Client update(Client client) {
        jdbcTemplate.update(UPDATE, new Object[]{
                client.getName(),
            client.getId()
        });
        return client;
    }

    public void delete(Client client) {
        delete(client.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE, new Object[]{
            id
        });
    }
}
