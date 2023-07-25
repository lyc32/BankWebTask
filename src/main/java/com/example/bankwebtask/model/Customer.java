package com.example.bankwebtask.model;

public class Customer extends User
{
    private String accountType;
    private double balance;
    private Address address;
    private String state;

    public Customer()
    {

    }

    public Customer(String firstName, String lastName, String userPass, String phoneNumber, String email, String accountType, Address address, String state) {
        super(firstName,lastName,userPass,phoneNumber,email);
        this.accountType = accountType;
        this.address = address;
        this.state = state;
    }

    public void setUserId(int userId)
    {
        super.setUserId(userId);
    }
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
