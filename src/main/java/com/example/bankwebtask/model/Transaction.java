package com.example.bankwebtask.model;

public class Transaction
{
    private int id;
    private String tDate;
    private String userId;
    private String object;
    private String detail;
    private double bill;


    public Transaction(String tDate, String userId, String object, String detail, double bill)
    {
        this.tDate = tDate;
        this.userId = userId;
        this.object = object;
        this.detail = detail;
        this.bill = bill;
    }

    public String getDate() {
        return tDate;
    }

    public void setDate(String tDate) {
        this.tDate = tDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
