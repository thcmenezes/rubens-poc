package com.rubens.configs;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static Dotenv load() {
        return dotenv;
    }
    public static String getValueByKey(String key){
        return dotenv.get(key);
    }

    // Migrar isso pra classe do MySQL usar polimorfismo pra ele saber qual o banco e deixar nome generico pro metodo
    public static String getMySQLConnection() {
        String connection = String.format("%s:%s://%s:%s/%s?user=%s&password=%s",
                dotenv.get("DATABASE_CONNECTION"),
                dotenv.get("MYSQL_DATABASE_TYPE"),
                dotenv.get("DATABASE_HOST"),
                dotenv.get("MYSQL_PORT"),
                dotenv.get("DATABASE_NAME"),
                dotenv.get("MYSQL_USER"),
                dotenv.get("MYSQL_PASSWORD"));

        return connection;
    }

    // Migrar isso pra classe do MySQL usar polimorfismo pra ele saber qual o banco e deixar nome generico pro metodo
    public static String getMySQLConnectionSimplify() {
        String connection = String.format("%s:%s://%s:%s/%s?user=%s&password=%s",
                dotenv.get("DATABASE_CONNECTION"),
                dotenv.get("MYSQL_DATABASE_TYPE"),
                dotenv.get("DATABASE_HOST"),
                dotenv.get("MYSQL_PORT"),
                dotenv.get("DATABASE_NAME"));

        return connection;
    }
}
