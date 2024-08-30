package br.ceub.contacts;

import java.util.Scanner;


public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Remove Contact");
            System.out.println("4. List Contacts");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.print("Enter name or phone number to search: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact.toString());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name or phone number to remove: ");
                    String removeQuery = scanner.nextLine();
                    if (contactList.removeContact(removeQuery)) {
                        System.out.println("Contact removed successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("\nContact List:");
                    contactList.listContacts();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}


