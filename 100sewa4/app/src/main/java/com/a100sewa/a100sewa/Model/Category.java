package com.a100sewa.a100sewa.Model;

/**
 * Created by yamun on 31/01/2018.
 */

public class Category {
    private String Name;
    private String Image;




    public Category() {

    }

    public Category(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
