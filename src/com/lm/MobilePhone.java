package com.lm;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber; // Acts as identifier of each mobile phone
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public void printOptions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To search / find a contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    public void printContacts() {
        System.out.println("Contact list (" + this.myContacts.size() + "):");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.print((i + 1) + ". ");
            printContact(i);
        }
    }

    public void addContact(String name, String phone) {
        if (inContacts(name)){
            System.out.println("Contact already on file");
        } else {
            Contacts newContact = new Contacts(name, phone);
            this.myContacts.add(newContact);
        }

    }

    private void updateContact(int position, Contacts newContact) {
        myContacts.set(position, newContact);
        System.out.println("Contact " + this.myContacts.get(position).getName() + " has been modified.");
    }

    public void updateContact(String name, String newName, String newPhone) {
        int position = findPosition(name);
        Contacts contact = this.getContact(name);
        contact.setName(newName);
        contact.setPhone(newPhone);
        System.out.println("Contact " + this.myContacts.get(position).getName() + " has been modified.");
        printContact(newName);
    }

    public void removeContact (String name) {
        int position = findPosition(name);
        if (inContacts(name)) {
            this.myContacts.remove(position);
            System.out.println("Contact " + name + " has been removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }
// Tim Buchalka builds this as a method in Contacts, which makes it somewhat easier
    public Contacts getContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {

            if (this.myContacts.get(i).getName().equals(name)) {
                return this.myContacts.get(i);
            }
        }
        return null;
    }

    private int findPosition(String name) {
        return this.myContacts.indexOf(getContact(name));
    }

    public boolean inContacts(String name) {
        if (this.findPosition(name)>=0){
            return true;
        }
        return false;
    }

    private void printContact (int position) {
        System.out.println(this.myContacts.get(position).getName() + ": " + this.myContacts.get(position).getPhone());
    }

    public void printContact (String name) {
        printContact(this.findPosition(name));
    }


}
