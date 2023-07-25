package com.example.bankwebtask.model;

public class Manager extends User
{
    // 0-7;
    // 0 visit customer
    // 1 customer requester;
    // 2 edit customer
    // 3 edit balance
    // 4 create Manager;
    // 5 database Operations;

    private int level;

    public Manager()
    {
    }

    public Manager(String firstName, String lastName, String userPass, String phoneNumber, String email, int level)
    {
        super(firstName, lastName, userPass, phoneNumber, email);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
