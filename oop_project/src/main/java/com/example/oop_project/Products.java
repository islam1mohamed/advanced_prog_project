package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class Products {

    public VBox root;


    @FXML
    public void initialize(){

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.NEVER);
        columnConstraints.setPercentWidth(50.00);


        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(Priority.NEVER);
        columnConstraints1.setPercentWidth(50.00);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.NEVER);


        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints1);

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(20 , 20 , 20 ,20));

        root.getChildren().add(scrollPane);
        for (int i = 0; i < Main.manager.products.size() ; i++){
            gridPane.add(Main.manager.products.get(i).display() , i % 2 , (int) i / 2);
        }
    }
}
