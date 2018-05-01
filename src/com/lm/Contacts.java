package com.lm;

public class Contacts {
    private String name;
    private String phone;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    // Calls constructor to create new contact and returns it
    // Created in lieu of method I created in MobilePhone getContact
    public static Contacts createContact (String name, String phone) {

        return new Contacts(name,phone);
    }
}
