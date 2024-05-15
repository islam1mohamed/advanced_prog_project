package com.example.oop_project;

public class Furniture extends Product{
    final String category = "Furniture";

    public Furniture(int itemId, String name,String description, String imageName,float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock);
    }


    @Override
    public String toString() {
        return itemId + "#" + name + "#" +description + "#" + imageName+ "#" + price + "#" + amountInStock + "#"  +category;
    }
}
