package com.example.oop_project;

public class Food extends Product implements Refundable{
    final String category = "Food";

    public Food(int itemId, String name,String description,String imageName, float price, int amountInStock) {
        super(itemId, name, description, imageName, price, amountInStock);
    }

    @Override
    public void refund(int amount) {
        Main.manager.products.get(Main.manager.products.indexOf(this)).amountInStock += amount;

    }


    @Override
    public String toString() {
        return itemId + "#" + name + "#" +description + "#" + imageName+ "#" + price + "#" + amountInStock + "#"  +category;
    }
}