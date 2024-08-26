package org.contact_list_mysql;

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

    }

    public static void updateContact() {

    }

    public static void deleteContact() {

    }
}
