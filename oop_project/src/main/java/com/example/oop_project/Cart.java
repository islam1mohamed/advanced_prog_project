package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cart {
    public VBox quantifiables;
    public Label totalText;

    @FXML
    float total;

    @FXML
    public void initialize(){
        for(Quantifiable q: Main.manager.cart  ){
            System.out.println(q.product.name);
            quantifiables.getChildren().add(buildQ(q));
            total += q.product.price * q.quantity;
        }

        totalText.setText("Total: " + total);
    }


    public Node buildQ(Quantifiable quantifiable){
        try {
            VBox root = new VBox();
            root.setPadding(new Insets(10 , 10 , 10 , 10));
            GridPane pane = new GridPane();
            pane.setStyle("-fx-background-radius: 18 18 18 18;-fx-background-color: #eee9f9;");
            pane.setPrefHeight(100);
            pane.setPrefWidth(580);
            pane.setAlignment(Pos.CENTER_RIGHT);
            pane.setHgap(10);


            RowConstraints rowConstraints1 = new RowConstraints();
            rowConstraints1.setPercentHeight(50.0);
            RowConstraints rowConstraints2 = new RowConstraints();
            rowConstraints2.setPercentHeight(50.0);

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.NEVER);
            columnConstraints.setPercentWidth(20.00);


            ColumnConstraints columnConstraints1 = new ColumnConstraints();
            columnConstraints1.setHgrow(Priority.NEVER);
            columnConstraints1.setPercentWidth(40.00);
            ColumnConstraints columnConstraints2 = new ColumnConstraints();
            columnConstraints2.setHgrow(Priority.NEVER);
            columnConstraints2.setPercentWidth(10.00);
            ColumnConstraints columnConstraints3 = new ColumnConstraints();
            columnConstraints3.setHgrow(Priority.NEVER);
            columnConstraints3.setPercentWidth(20.00);
            ColumnConstraints columnConstraints4 = new ColumnConstraints();
            columnConstraints4.setHgrow(Priority.NEVER);
            columnConstraints4.setPercentWidth(10.00);
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.NEVER);

            pane.getRowConstraints().add(rowConstraints);
            pane.getColumnConstraints().add(columnConstraints);
            pane.getColumnConstraints().add(columnConstraints1);
            pane.getColumnConstraints().add(columnConstraints2);
            pane.getColumnConstraints().add(columnConstraints3);
            pane.getColumnConstraints().add(columnConstraints4);

            Image image = new Image("file:images/"+quantifiable.product.imageName);
            ImageView iv = new ImageView(image);
            iv.setFitHeight(100);
            iv.setFitWidth(100);
            iv.setCache(true);



            GridPane info = getGridPane(quantifiable);
            Label amount = new Label(String.valueOf(quantifiable.quantity));
            amount.setStyle("-fx-font: 14 arial;-fx-font-weight: bold;");

            Button minus = new Button();
            minus.addEventFilter(MouseEvent.MOUSE_CLICKED , mouseEvent -> {
                if(quantifiable.quantity != 1)
                    quantifiable.quantity--;
                else{
                    Main.manager.cart.remove(quantifiable);
                    quantifiables.getChildren().remove(root);
                }
                amount.setText(String.valueOf(quantifiable.quantity));
                recalculateTotal();
            });
            minus.setText("-");
            Button plus = new Button();
            plus.setText("+");
            plus.addEventFilter(MouseEvent.MOUSE_CLICKED ,mouseEvent -> {
                if(quantifiable.quantity != quantifiable.product.amountInStock)
                    quantifiable.quantity++;
                amount.setText(String.valueOf(quantifiable.quantity));
                recalculateTotal();
            });

            pane.add(iv , 0 , 0);
            pane.add(info , 1 , 0);
            pane.add(minus ,2 , 0);
            pane.add(amount ,3 , 0);
            pane.add(plus ,4 , 0);
            GridPane.setHalignment(minus , HPos.CENTER);
            GridPane.setHalignment(plus , HPos.CENTER);
            GridPane.setHalignment(amount , HPos.CENTER);

            root.getChildren().add(pane);
            return root;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static GridPane getGridPane(Quantifiable quantifiable) {
        GridPane info = new GridPane();

        info.setVgap(10.0);
        Label name = new Label(quantifiable.product.name);
        name.setStyle("-fx-font: 18 arial;-fx-font-weight: bold;");

        name.setPrefHeight(70);
        name.setWrapText(true);
        Label price = new Label(String.valueOf(quantifiable.product.price));
        price.setStyle("-fx-font: 14 arial;-fx-font-weight: bold;");

        info.add(name , 0 , 0);
        info.add(price , 0 , 1);
        return info;
    }

    private void recalculateTotal(){
        total = 0;
        for(Quantifiable q: Main.manager.cart  ){
            total += q.product.price * q.quantity;
        }

        totalText.setText("Total: " + total);
    }

    public void onCheckClick(ActionEvent actionEvent) {

        //Create Order

        Map<Integer, Integer> map = new HashMap<>();
        for(Quantifiable q: Main.manager.cart){
            map.put(q.product.itemId , q.quantity);
            q.product.amountInStock -= q.quantity;
            Main.manager.updateProduct(q.product);
        }
        Random rand = new Random();
        Order order = new Order(rand.nextInt(10000) , LocalDateTime.now().toString() , map);
        order.register();
        Main.manager.orders.add(order);
        quantifiables.getChildren().clear();
        Main.manager.cart.clear();
        recalculateTotal();
    }
}
