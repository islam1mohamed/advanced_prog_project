package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProductDetails {

    public ImageView image;
    public Label name;
    public Label description;
    public Button addToCart;
    public Label amount;
    public Button minus;
    public Button plus;
    public Label price;
    public Label stockNumber;

    Product product;

    public void setProduct(Product product){
        this.product = product;
        Image im = new Image("file:images/"+ product.imageName);
        image.setImage(im);
        name.setText(product.name);
        price.setText(String.valueOf(product.price));
        description.setText(product.description);
        if(product.amountInStock == 0){
            plus.setDisable(true);
            minus.setDisable(true);
            stockNumber.setText("Out of Stock");
        }
        else {
            stockNumber.setText(String.valueOf(product.amountInStock));
        }
    }



    public void onAddToCartClick(ActionEvent actionEvent) {
        int currentAmount = Integer.parseInt(amount.getText());

        if(currentAmount!= 0){

            Main.manager.cart.add(new Quantifiable(currentAmount , product));
        }
        back();
    }

    public void onPlusClick(ActionEvent actionEvent) {
        int currentAmount = Integer.parseInt(amount.getText());
        if(currentAmount != product.amountInStock) {
            amount.setText(String.valueOf((currentAmount+1)));
        }
    }
    public void onMinusClick(ActionEvent actionEvent) {
        int currentAmount = Integer.parseInt(amount.getText());
        if(currentAmount != 0){
            amount.setText(String.valueOf(currentAmount -1));
        }
    }

    public void onBackClicked(ActionEvent mouseEvent) {

        back();
    }

    private void back(){

        try {

            Stage stage = (Stage) name.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-screen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Home Screen");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
