package com.deeon.model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

final class HikariCPDataSource {

    private static HikariConfig config = new HikariConfig("/com/deeon/hikari.properties");
    private static HikariDataSource ds = new HikariDataSource(config);

//    static {
//        config.setJdbcUrl("jdbc:sqlserver://192.168.11.11\\sqlserver;databaseName=workbench");
//        config.setUsername("sa");
//        config.setPassword("Pp0");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        ds = new HikariDataSource(config);
//    }

     static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private HikariCPDataSource(){}

}
