package com.example.oop_project;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public abstract  class Product extends StoreItem{
    String name;
    String description;
    String imageName;
    float price;
    int amountInStock;


    public Product(int itemId, String name, String description,String imageName,  float price, int amountInStock) {
        super(itemId);
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
        this.amountInStock = amountInStock;
    }


    public static  Product fromString(String string) throws  Exception{
        String[] data = string.split("#");
        return switch (data[6]) {
            case "Clothing" ->
                    new Clothing(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Electronics" ->
                    new Electronics(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Food" ->
                    new Food(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            case "Furniture" ->
                    new Furniture(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
            default -> throw new Exception();
        };
    }

    @Override
    public Node display() {
        try {
            VBox pane = new VBox();
            pane.setStyle("-fx-background-size: 1200 900;-fx-background-radius: 18 18 18 18; -fx-border-radius: 0 0 18 18;-fx-background-color: #eee9f9;");
            pane.setPrefHeight(300);
            pane.setAlignment(Pos.TOP_CENTER);
            pane.setSpacing(10);
            Label label = new Label(name);
            label.setStyle("-fx-font: 14 arial;-fx-font-weight: bold;");
            Label priceText = new Label(price + "$");
            priceText.setStyle("-fx-font: 18 arial;-fx-font-weight: bold;-fx-text-fill: #29d678");

            Label stockNumber = new Label();
            if(amountInStock == 0){
                stockNumber.setText("Unavailable");
                stockNumber.setStyle("-fx-font: 18 arial;-fx-font-weight: bold;-fx-text-fill: #FF0000");
            }
            else{
                    stockNumber.setText(amountInStock + " In Stock");
                    stockNumber.setStyle("-fx-font: 18 arial;-fx-font-weight: bold;-fx-text-fill: #000000");
            }
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.NEVER);
            columnConstraints.setPercentWidth(50.00);


            ColumnConstraints columnConstraints1 = new ColumnConstraints();
            columnConstraints1.setHgrow(Priority.NEVER);
            columnConstraints1.setPercentWidth(50.00);
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.NEVER);

            columnConstraints.setPercentWidth(50.0);
            GridPane info = new GridPane();
            info.getRowConstraints().add(rowConstraints);
            info.getColumnConstraints().add(columnConstraints);
            info.getColumnConstraints().add(columnConstraints1);
            info.setAlignment(Pos.CENTER);
            GridPane.setHalignment(priceText , HPos.CENTER);
            GridPane.setHalignment(stockNumber , HPos.CENTER);

            info.add(priceText ,0 , 0);
            info.add(stockNumber ,1 , 0);

            Image image = new Image("file:images/"+imageName);
            ImageView iv = new ImageView(image);
            iv.setFitWidth( 240);
            iv.setFitHeight( 240);
            Product currentProduct = this;
            pane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {

                    Stage stage = (Stage) pane.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-details.fxml"));
                        Parent root = fxmlLoader.load();
                    ProductDetails productDetails;
                    productDetails = fxmlLoader.getController();
                    productDetails.setProduct(currentProduct);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Product Details");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });

            pane.getChildren().add(iv);
            pane.getChildren().add(label);
            pane.getChildren().add(info);

            return pane;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
