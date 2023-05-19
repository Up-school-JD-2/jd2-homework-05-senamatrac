package com.upschool.senamatrac.homework5.data;

public class User {
    private final String  fistName;
    private final String  lastName;

    public User(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    //region GETTER_SETTER
    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }
    //endregion
}
