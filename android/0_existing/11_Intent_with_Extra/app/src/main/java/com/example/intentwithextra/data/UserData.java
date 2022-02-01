package com.example.intentwithextra.data;

import java.io.Serializable;

public class UserData implements Serializable {

    public String firstName;
    public String lastName;
    public Boolean hasDog;

    public UserData(String firstName, String lastName, Boolean hasDog) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasDog = hasDog;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", firstName, lastName, hasDog);
    }

    public String printNice() {
        return String.format("First name: %s, Last name: %s, Has dog: %s", firstName, lastName, hasDog);
    }

    public String getFirstName() {
        return this.firstName;
    }

}