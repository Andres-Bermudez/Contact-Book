package org.contact_list_mysql;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactService {

    public static void createContact() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        String last_name = "";
        String cellphone_number = "";

        System.out.println();
        System.out.println("Creating a new contact...");
        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Last Name: ");
        last_name = sc.nextLine();

        System.out.print("Cellphone number: ");
        cellphone_number = sc.nextLine();

        Contact contact = new Contact();
        contact.setName(name);
        contact.setLast_name(last_name);
        contact.setCellphone_number(cellphone_number);

        ContactDAO.createContactDB(contact);
    }

    public static void showContacts() {
        System.out.println("- Your contacts  -----> ");
        ContactDAO.readContactDB();
    }

    public static void updateContact() {
        Scanner sc = new Scanner(System.in);
        int idContact = 0;

        System.out.println();
        System.out.println("Updating contact...");
        System.out.print("Enter the ID of the contact you are going to modify: ");

        try {
            idContact = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Error: ¡The id must be a numeric value!");
            updateContact();
        }

        sc.nextLine();

        System.out.print("Enter the new name: ");
        String newNameContact = sc.nextLine();

        System.out.print("Enter the new last name: ");
        String newLastName = sc.nextLine();

        System.out.print("Enter the new phone number: ");
        String newCellphoneNumber = sc.nextLine();

        Contact contact = new Contact();
        contact.setId(idContact);
        contact.setName(newNameContact);
        contact.setLast_name(newLastName);
        contact.setCellphone_number(newCellphoneNumber);

        ContactDAO.updateContactDB(contact);
    }

    public static void deleteContact() {
        Scanner sc = new Scanner(System.in);
        int idContact = 0;

        System.out.println();
        System.out.println("Deleting contact...");
        System.out.print("Enter the id of the contact you are going to delete: ");

        try {
            idContact = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Error: ¡The id must be a numeric value!");
            deleteContact();
        }

        System.out.println();
        System.out.println(">>> The contact you are going to delete is:");
        ContactDAO.searchContact(idContact);

        sc.nextLine();

        // Confirmar eliminacion del contacto
        String confirmation = "";

        System.out.println();
        System.out.print("Enter 'Yes' to confirm the deletion of the contact: ");
        confirmation = sc.nextLine();

        if (confirmation.equals("Yes")) {
            ContactDAO.deleteContactDB(idContact);
        } else {
            System.out.println();
            System.out.println("¡Operation cancelled!");
        }
    }

    public static void emptyAgenda() {
        ContactDAO.emptyAgendaDB();
    }
}
