package org.contact_list_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection conecctionDB() {

        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/contact_list_db";
        String username = "arsenius";
        String password = "debiandell*";

        Connection connection = null;

        try {
            // Establecer la conexión
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("¡Successful Connection!");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
        return connection;
    }
}
