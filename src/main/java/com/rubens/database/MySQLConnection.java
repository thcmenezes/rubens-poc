package com.rubens.database;

import com.rubens.configs.EnvConfig;

public class MySQLConnection extends AbstractDatabaseConnection {
    @Override
    public String getAddressHost() {
        String urlHost = String.format("%s:%s://%s:%s/%s?user=%s&password=%s",
                EnvConfig.load().get("DATABASE_CONNECTION"),
                EnvConfig.load().get("MYSQL_DATABASE_TYPE"),
                EnvConfig.load().get("DATABASE_HOST"),
                EnvConfig.load().get("MYSQL_PORT"),
                EnvConfig.load().get("DATABASE_NAME"));

        return urlHost;
    }

    @Override
    public String getUsername() {
        return EnvConfig.getValueByKey("MYSQL_USER");
    }

    @Override
    public String getPassword() {
        return EnvConfig.getValueByKey("MYSQL_PASSWORD");
    }

}
