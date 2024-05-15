package com.example.oop_project;

import javafx.scene.Node;

public abstract class StoreItem {
    int itemId;

    public StoreItem(int itemId) {
        this.itemId = itemId;
    }

    public abstract String toString ();

    public static StoreItem fromString(String string) throws  Exception{
        return null;
    }

    public abstract Node display();
}
