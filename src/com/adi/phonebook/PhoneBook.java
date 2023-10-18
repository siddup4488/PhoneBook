package com.adi.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class PhoneBook  {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void removeContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().toLowerCase().equals(name.toLowerCase())) {
                iterator.remove();
                System.out.println("Contact removed: " + contact);
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }

    public List<Contact> searchContacts(String searchString, boolean searchByPhoneNumber) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (searchByPhoneNumber) {
                if (contact.getPhoneNumber().contains(searchString)) {
                    searchResults.add(contact);
                }
            } else {
                if (contact.getName().toLowerCase().contains(searchString.toLowerCase())) {
                    searchResults.add(contact);
                }
            }
        }
        return searchResults;
    }

    public void updateContact(String oldName, String newName, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().equals(oldName.toLowerCase())) {
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                System.out.println("Contact updated: " + contact);
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }
}