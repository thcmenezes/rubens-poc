package com.rubens.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDatabaseConnection implements DatabaseConnection {
    protected boolean connected;
    public Connection connection;

    @Override
    public Connection connect() {
        try {
            // return DriverManager.getConnection(host);
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(this.getAddressHost());
        config.setUsername(this.getUsername());
        config.setPassword(this.getPassword());
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
