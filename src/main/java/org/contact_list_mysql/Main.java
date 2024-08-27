package org.contact_list_mysql;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Menu de bienvenida
        Scanner sc = new Scanner(System.in);

        int userOption = 0;

        do {
            System.out.println();
            System.out.println(":: Contact List ::");
            System.out.println("    1. Create contact.");
            System.out.println("    2. Show contacts.");
            System.out.println("    3. Update contact.");
            System.out.println("    4. Delete contact.");
            System.out.println("    5. Exit.");
            System.out.print("Your choice: ");

            try {
                userOption = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error: ¡Remember to choose from the available options!");
                System.exit(0);
            }

            switch (userOption) {
                case 1:
                    ContactService.createContact();
                    break;
                case 2:
                    ContactService.showContacts();
                    break;
                case 3:
                    ContactService.updateContact();
                    break;
                case 4:
                    ContactService.deleteContact();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: ¡Remember to choose from the available options!");
                    break;
            }
        } while(true);
    }
}