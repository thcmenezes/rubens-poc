package com.rubens.database;

import java.sql.Connection;

public interface DatabaseConnection<T> {
    Connection connect();
    void disconnect();
    boolean isConnected();
    String getAddressHost();
    String getUsername();
    String getPassword();
}
