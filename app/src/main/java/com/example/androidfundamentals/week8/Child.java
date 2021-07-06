package com.example.androidfundamentals.week8;

import com.google.gson.annotations.SerializedName;

public class Child {
    @SerializedName("firstname")
    private String name;
    @SerializedName("lastname")
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
