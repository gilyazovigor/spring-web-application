package com.example.test_task;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatasourceConfig {

    private DatasourceConfig(){}

    public static DataSource createDataSource(){

        HikariConfig config  = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Organizations");
        config.setUsername("postgres");
        config.setPassword("1");
        config.setAutoCommit(true);
        config.setMaximumPoolSize(32);
        return new HikariDataSource(config);
    }
}
