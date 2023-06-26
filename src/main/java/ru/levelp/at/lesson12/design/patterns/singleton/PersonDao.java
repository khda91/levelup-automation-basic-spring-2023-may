package ru.levelp.at.lesson12.design.patterns.singleton;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {

    private static final String SELECT_ALL = "SELECT * FROM person";

    private final JdbcTemplate jdbcTemplate;

    public PersonDao(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> getPerson() {
        return jdbcTemplate.queryForMap(SELECT_ALL);
    }
}
