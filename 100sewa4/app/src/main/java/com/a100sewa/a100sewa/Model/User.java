package com.a100sewa.a100sewa.Model;

/**
 * Created by yamun on 30/01/2018.
 */

public class User {
    private String Name;
    private String Password;
    private String Phone;
    private String Isstaff;

    public User() {

    }

    public User(String name, String password, String phone) {
        Name = name;
        Password = password;
        Phone = phone;
        Isstaff=false;
    }

    public String getIsstaff() {
        return Isstaff;
    }

    public void setIsstaff(String isstaff) {
        Isstaff = isstaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
