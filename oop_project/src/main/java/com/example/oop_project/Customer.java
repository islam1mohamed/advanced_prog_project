package com.example.oop_project;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer extends User{

    StoreItem[] cart;

    public Customer(String username, String password, String id, String name, String email) {
        super(username, password, id, name, email);
    }


    void addToCart(StoreItem item){
        ArrayList<StoreItem> arrayList = new ArrayList<StoreItem>(Arrays.asList(cart));
        arrayList.add(item);
        cart = arrayList.toArray(cart);
    }

    void removeFromCart(StoreItem item){
        ArrayList<StoreItem> arrayList = new ArrayList<StoreItem>(Arrays.asList(cart));
        arrayList.remove(item);
        cart = arrayList.toArray(cart);
    }

    boolean hasItem(StoreItem item){
        for(StoreItem sItem : cart){
            if(item.itemId == sItem.itemId)
                return true;
        }
        return false;
    }
}
