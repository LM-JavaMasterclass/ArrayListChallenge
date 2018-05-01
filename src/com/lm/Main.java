package com.lm;

import java.util.Scanner;

public class Main {
    // Created by Laura Macia: 04/26/2018
    // Udemy Complete Java Masterclass with Tim Buchalka
    // Answer to Challenge: ArrayLists
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.


    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone("4123043993");



    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        mobile.printOptions();

        while (!quit) {
            System.out.println("Please enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    mobile.printOptions();
                    break;
                case 1:
                    mobile.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    private static void addContact() {
        System.out.println("Enter name of contact to add:");
        String name = scanner.nextLine();
        System.out.println("Enter " + name + "'s phone number:");
        String phone = scanner.nextLine();
        mobile.addContact(name, phone);
        // TB uses here the STATIC method he created for the contact (convenience method)
        // It allows to not access without needing an instance of that object.
        // BRILLIANT
        // called: Contact newContact = Contact.createContact(name,phone);
        //                              This is capitalized because it refers to the CLASS
    }
    private static void updateContact() {
        int option;
        System.out.println("Enter name of contact to update:");
        String name = scanner.nextLine();
        String newName = mobile.getContact(name).getName();
        String newPhone = mobile.getContact(name).getPhone();

        if (mobile.inContacts(name)) {
            System.out.println("Update (1) name, (2) phone, or (3) both?");
            option = scanner.nextInt();
            scanner.nextLine();  // nextInt() doesn't finish the line,so this one "flushes" it

            switch (option) {
                case 1:
                    System.out.println("Enter new name:");
                    newName = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Enter new phone:");
                    newPhone = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter new name:");
                    newName = scanner.nextLine();
                    System.out.println("Enter new phone:");
                    newPhone = scanner.nextLine();
                    break;
                default:
                    System.out.println("Option entered not valid.");
                    break;
            }
            mobile.updateContact(name, newName, newPhone);
        } else{
            System.out.println("Name provided not in contacts.");
        }
    }

    private static void removeContact(){
        System.out.println("Enter name of contact to remove:");
        String name = scanner.nextLine();
        if (mobile.inContacts(name)){
            mobile.removeContact(name);
        } else {
            System.out.println("Name provided not in contacts.");
        }
    }

    private static void findContact (){
        System.out.println("Enter name of contact to be found:");
        String name = scanner.nextLine();
        if (mobile.inContacts(name)){
            System.out.println("Contact found.");
            mobile.printContact(name);
        } else {
            System.out.println("Name provided not in contacts.");
        }
    }




}
