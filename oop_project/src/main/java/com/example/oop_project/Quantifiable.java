package com.example.oop_project;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Quantifiable {
    int quantity;
    Product product;

    public Quantifiable(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }


}
