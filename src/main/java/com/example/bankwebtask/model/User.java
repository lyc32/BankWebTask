package com.example.bankwebtask.model;

public class User
{
    private int userId;
    private String firstName;
    private String lastName;
    private String userPass;
    private String phoneNumber;
    private String email;

    public User()
    {}

    public User(String firstName, String lastName, String userPass, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPass = userPass;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
