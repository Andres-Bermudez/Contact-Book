package org.contact_list_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {

    public static void createContactDB(Contact contact) {
        // Iniciar conexion con la base de datos
        ConnectionDB connection = new ConnectionDB();

        try(Connection connect = connection.conecctionDB()) {
            PreparedStatement preparedStatement = null;
            try {
                String query = "INSERT INTO contact(name, last_name, cellphone_number) VALUES (?, ?, ?)";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, contact.getName());
                preparedStatement.setString(2, contact.getLast_name());
                preparedStatement.setString(3, contact.getCellphone_number());
                preparedStatement.executeUpdate();
                System.out.println();
                System.out.println("¡Contact added successfully!");
            } catch (SQLException e) {
                System.out.println("Error: ¡Contact could not be created!");
                System.out.println("Check the data you are entering.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
    }

    public static void readContactDB() {

    }

    public static void updateContactDB(Contact contact) {

    }

    public static void deleteContactDB(int idContact) {

    }
}
