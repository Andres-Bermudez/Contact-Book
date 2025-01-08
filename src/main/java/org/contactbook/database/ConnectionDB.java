package org.contactbook.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection conecctionDB() {

        // Información de conexión a con la base de datos
        String url = "jdbc:mysql://localhost:3306/${NAME_DATABASE}";
        String username = "${USERNAME}";
        String password = "${PASSWORD}";

        Connection connection = null;

        try {
            // Establecer la conexión
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("¡Successful Connection!");
                return connection;
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
        return null;
    }
}
