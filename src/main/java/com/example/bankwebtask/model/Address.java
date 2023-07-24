package com.example.bankwebtask.model;

public class Address
{
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;

    public Address()
    {

    }

    public Address(String json)
    {
        String[] array = json.substring(1, json.length()-2).split(",");

        String[] tmp = array[0].split(":");
        line1 = tmp[1].substring(1,tmp[1].length()-2);

        tmp = array[1].split(":");
        line2 = tmp[1].substring(1,tmp[1].length()-2);

        tmp = array[2].split(":");
        city = tmp[1].substring(1,tmp[1].length()-2);

        tmp = array[3].split(":");
        state = tmp[1].substring(1,tmp[1].length()-2);

        tmp = array[4].split(":");
        zipCode = tmp[1].substring(1,tmp[1].length()-2);

    }
    public Address(String line1, String line2, String city, String state, String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void print()
    {
        System.out.println("  " + line1);
        System.out.println("  " + line2);
        System.out.println("  " + city + ", " + state);
        System.out.println("  " + zipCode);
    }

    public String toJson()
    {
        return "{line1:\""+line1+"\", line2:\""+line2+"\", city:\""+city+"\", state:\""+state+"\", zipCode:\""+zipCode+"\"}";
    }
}
