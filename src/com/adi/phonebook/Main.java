package com.adi.phonebook;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Phone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.println("Search by:");
                    System.out.println("1. Name");
                    System.out.println("2. Phone Number");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    String searchString;
                    boolean searchByPhoneNumber = false;
                    if (searchChoice == 1) {
                        System.out.print("Enter search pattern (name): ");
                        searchString = scanner.nextLine();
                    } else if (searchChoice == 2) {
                        System.out.print("Enter search pattern (phone number): ");
                        searchString = scanner.nextLine();
                        searchByPhoneNumber = true;
                    } else {
                        System.out.println("Invalid choice. Returning to the main menu.");
                        continue;
                    }

                    List<Contact> searchResults = phoneBook.searchContacts(searchString, searchByPhoneNumber);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Contact contact : searchResults) {
                            System.out.println(contact);
                        }
                    } else {
                        System.out.println("No matching contacts found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    phoneBook.updateContact(oldName, newName, newPhoneNumber);
                    break;
                case 4:
                    System.out.print("Enter name of contact to delete: ");
                    name = scanner.nextLine();
                    phoneBook.removeContact(name);
                    break;
                case 5:
                    List<Contact> contacts = phoneBook.getContacts();
                    if (!contacts.isEmpty()) {
                        System.out.println("All Contacts:");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                    } else {
                        System.out.println("Phone book is empty.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
