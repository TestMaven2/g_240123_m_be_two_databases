package de.telran.g_240123_m_be_two_databases.domain.db;

import java.sql.Connection;
import java.sql.DriverManager;

import static de.telran.g_240123_m_be_two_databases.constants.Constants.*;

public class DogConnector {

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_URL, DB_DOGS_SCHEMA_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}