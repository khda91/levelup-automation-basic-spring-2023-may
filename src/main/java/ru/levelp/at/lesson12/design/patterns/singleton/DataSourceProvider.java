package ru.levelp.at.lesson12.design.patterns.singleton;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class DataSourceProvider {

    private static DataSource dataSource;

    private DataSourceProvider() {

    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            var config = new HikariConfig();
            config.setJdbcUrl("");
            config.setUsername("");
            config.setPassword("");
            dataSource = new HikariDataSource(config);
        }

        return dataSource;
    }
}
