package com.example.oop_project;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StoreManager {


    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();


    ArrayList<Quantifiable> cart = new ArrayList<>();


    User currentUser;

    StoreManager(User currentUser){
        this.currentUser = currentUser;
        try {
            File productsFile = new File("products.txt");
            if (productsFile.exists()) {
                    Scanner customersReader = new Scanner(productsFile);
                    while (customersReader.hasNextLine()) {
                        String data = customersReader.nextLine();
                        Product product = Product.fromString(data);

                        products.add(product);
                    }
                    customersReader.close();
            }
            else {
                productsFile.createNewFile();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            File ordersFile = new File(currentUser.id +"_orders.txt");
            if (ordersFile.exists()) {
                Scanner customersReader = new Scanner(ordersFile);
                while (customersReader.hasNextLine()) {
                    String data = customersReader.nextLine();
                    orders.add(Order.fromString(data));
                    System.out.println(orders.get(orders.size()-1).toString());
                }
                customersReader.close();
            }
            else {
                ordersFile.createNewFile();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void addProduct(Product product){
        products.add(product);
        File productsFile = new File("products.txt" );
        try {
            if (productsFile.exists()) {
                FileWriter fileWriter = new FileWriter(productsFile , true);
                fileWriter.write(product.toString() + '\n');
                fileWriter.close();
            }
        }catch (Exception e){

        }
    }

    void removeProduct(Product product){
        File productsFile = new File("products.txt" );
        StringBuilder newFileString = new StringBuilder();
        try {
            if (productsFile.exists()) {
                Scanner customersReader = new Scanner(productsFile);
                while (customersReader.hasNextLine()) {
                    String data = customersReader.nextLine();
                    String[] dataFields = data.split(",");
                    if (!dataFields[0].equals(String.valueOf(product.itemId))) {
                        newFileString.append(data).append('\n');
                    }
                }
                FileWriter fileWriter = new FileWriter(productsFile);
                fileWriter.write(newFileString.toString());
                fileWriter.close();
            }
        }catch (Exception e){

        }
    }

    public void updateProduct(Product product) {
        File productsFile = new File("products.txt" );
        StringBuilder newFileString = new StringBuilder();
        try {
            if (productsFile.exists()) {
                Scanner customersReader = new Scanner(productsFile);
                while (customersReader.hasNextLine()) {
                    String data = customersReader.nextLine();
                    String[] dataFields = data.split(",");
                    if (!dataFields[0].equals(String.valueOf(product.itemId))) {
                        newFileString.append(data).append('\n');
                    }
                    else{
                        newFileString.append(product.toString()).append('\n');

                    }
                }
                FileWriter fileWriter = new FileWriter(productsFile);
                fileWriter.write(newFileString.toString());
                fileWriter.close();
            }
        }catch (Exception e){

        }
    }
}
