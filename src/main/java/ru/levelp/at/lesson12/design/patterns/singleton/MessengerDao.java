package ru.levelp.at.lesson12.design.patterns.singleton;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.levelp.at.lesson12.design.patterns.singleton.model.MessengerEntity;

public class MessengerDao {

    private static final String SELECT_ALL = "SELECT * FROM messenger";
    private static final String SELECT_ALL_BY_PERSON_ID = "SELECT * FROM messenger WHERE person_id = ?";

    private final JdbcTemplate jdbcTemplate;

    public MessengerDao(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> getMessengers() {
        return jdbcTemplate.queryForMap(SELECT_ALL);
    }

    public List<MessengerEntity> getMessengers(final String personId) {
        return jdbcTemplate.query(SELECT_ALL_BY_PERSON_ID, (rs, rowNum) ->
            new MessengerEntity(
                rs.getString("id"),
                rs.getString("person_id"),
                rs.getString("messenger_id"),
                rs.getString("nickname")
            ), personId);
    }

    public List<MessengerEntity> getMessengersFromFile(final String personId) {
        String sql;
        try {
            sql = Files
                .readString(Paths
                    .get(this.getClass()
                             .getResource(
                                 "/ru/levelp/at/lesson12/design/patterns/singleton/getMessengersByPersonId.sql")
                             .getPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new MessengerEntity(
                rs.getString("id"),
                rs.getString("person_id"),
                rs.getString("messenger_id"),
                rs.getString("nickname")
            ), personId);
    }
}
