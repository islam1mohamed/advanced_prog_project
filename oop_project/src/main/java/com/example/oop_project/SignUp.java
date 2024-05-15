package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.util.UUID;
import java.util.regex.Pattern;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SignUp {

    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public TextField email;
    @FXML
    public TextField name;

    public void onRegisterClick(ActionEvent actionEvent) {
       signup();
    }

    public void onUsernameDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            password.requestFocus();
        }
    }

    public void onPasswordDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            email.requestFocus();
        }
    }
    public void onEmailDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
           signup();
        }
    }
    public void onNameDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            username.requestFocus();
        }
    }

    private void signup(){
        if(!username.getText().trim().isEmpty() && !password.getText().trim().isEmpty() && !email.getText().trim().isEmpty() && !name.getText().trim().isEmpty()){
            String uniqueID = UUID.randomUUID().toString();
            Customer customer = new Customer(username.getText() , password.getText(),uniqueID ,email.getText() , name.getText());
            //validatiom
            try {
                User.signUp(customer);
                Stage stage = (Stage) username.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-screen.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void onLoginClick(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) username.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Login");
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
