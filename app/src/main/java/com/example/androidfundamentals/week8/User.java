package com.example.androidfundamentals.week8;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("address")
    private String homeAddress;
    @SerializedName("child")
    private Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", childName='" + child.getName() + '\'' +
                ", childLastName='" + child.getSurname() + '\'' +
                '}';
    }


}
