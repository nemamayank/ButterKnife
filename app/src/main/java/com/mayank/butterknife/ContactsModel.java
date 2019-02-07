package com.mayank.butterknife;

/**
 *
 */

public class ContactsModel {
    String name;
    String number;

    public ContactsModel(String name, String mobile) {
        this.name = name;
        this.number = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
