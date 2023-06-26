package ru.levelp.at.lesson12.design.patterns.singleton;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UniversalDao {

    private static final String SELECT_ALL = "SELECT * FROM ";

    private final JdbcTemplate jdbcTemplate;

    public UniversalDao(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> getAll(final String tableName) {
        return jdbcTemplate.queryForMap(SELECT_ALL + tableName);
    }
}
