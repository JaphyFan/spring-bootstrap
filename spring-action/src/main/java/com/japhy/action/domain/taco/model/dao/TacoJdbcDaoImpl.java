package com.japhy.action.domain.taco.model.dao;

import com.japhy.action.domain.taco.model.entity.Taco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2020/7/7 14:11
 */
@RequiredArgsConstructor
@Component
public class TacoJdbcDaoImpl implements TacoDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Taco> findAll() {
        return jdbcTemplate.query("select id, create, name from taco", this::mapToTaco);
    }

    @Override
    public Taco findOne(Long id) {
        return jdbcTemplate.queryForObject("select id, create, name from taco where id = ?",
            this::mapToTaco, id);
    }

    @Override
    public Taco save(Taco taco) {
        jdbcTemplate
            .update("insert into taco (id, name, create) values (?, ?, ?)", taco.getId(),
                taco.getName(), taco.getCreate());
        return taco;
    }

    private Taco mapToTaco(ResultSet rs, int rowNum) throws SQLException {
        return new Taco(rs.getLong("id"),
            new Date(rs.getTimestamp("create").toInstant().toEpochMilli()),
            rs.getString("name"),
            Collections.emptyList());
    }
}
