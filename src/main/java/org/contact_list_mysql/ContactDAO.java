package org.contact_list_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {

    public static void createContactDB(Contact contact) {
        // Iniciar conexion con la base de datos
        ConnectionDB connection = new ConnectionDB();

        try(Connection connect = connection.conecctionDB()) {
            // Objeto para preparar la sentencia
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

            }catch (SQLException e) {
                System.out.println("Error: ¡Contact could not be created!");
            }
        } catch (SQLException e) {
            System.out.println("Check the data you are entering.");
        }
    }

    public static void readContactDB() {
        ConnectionDB connection = new ConnectionDB();

        // Objeto que nos permite traer los datos en filas para ser mostrados
        ResultSet resultset = null;

        try(Connection connect = connection.conecctionDB()) {
            PreparedStatement preparedStatement = null;
            try {
                String query = "SELECT * FROM contact";

                preparedStatement = connect.prepareStatement(query);
                resultset = preparedStatement.executeQuery();

                while (resultset.next()) {
                    System.out.println();
                    System.out.println("ID: " + resultset.getInt("id"));
                    System.out.println("Name: " + resultset.getString("name"));
                    System.out.println("Last_Name: " + resultset.getString("last_name"));
                    System.out.println("Cellphone Number: " + resultset.getString("cellphone_number"));
                }
            } catch (SQLException e) {
                System.out.println("Error: ¡Could not read data!");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
    }

    public static void updateContactDB(Contact contact) {
        ConnectionDB connection = new ConnectionDB();

        try(Connection connect = connection.conecctionDB()) {
            PreparedStatement preparedStatement = null;
            try {
                String query = "UPDATE contact SET name = ?, last_name = ?, cellphone_number = ? WHERE id = ?";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, contact.getName());
                preparedStatement.setString(2, contact.getLast_name());
                preparedStatement.setString(3, contact.getCellphone_number());
                preparedStatement.setInt(4, contact.getId());
                preparedStatement.executeUpdate();
                System.out.println("¡Contact modified successfully!");

            } catch (SQLException e) {
                System.out.println("Error: ¡The contact could not be updated!");
                System.out.println("Check the data you are entering.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
    }

    public static void deleteContactDB(int idContact) {
        ConnectionDB connection = new ConnectionDB();

        try(Connection connect = connection.conecctionDB()) {
            PreparedStatement preparedStatement = null;
            try {
                String query = "DELETE FROM contact WHERE id = ?";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1, idContact);
                preparedStatement.executeUpdate();
                System.out.println("¡The contact has been deleted successfully!");

            } catch (SQLException e) {
                System.out.println("¡It was not possible to delete the contact!");
            }
        } catch (SQLException e) {
            System.out.println("Error: ¡It was not possible to delete the contact!");
            System.out.println("Check the data you are entering.");
        }
    }
}
