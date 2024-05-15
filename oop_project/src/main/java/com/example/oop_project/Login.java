package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.UUID;

public class Login {



    @FXML
    public TextField username;

    @FXML
    public TextField password;
    public Label error;

    public void onUsernameDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            password.requestFocus();
        }
    }

    public void onPasswordDone(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            login();
        }
    }

    public void onLoginClick(ActionEvent actionEvent) {
        login();
    }



    void login(){
        if(!username.getText().trim().isEmpty() && !password.getText().trim().isEmpty() ){

            try{
                User.login(username.getText() , password.getText());
                Stage stage = (Stage) username.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-screen.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
            }
            catch (RegisterException e){
                error.setText(e.message);
            }
            catch (FileNotFoundException e){
                error.setText("Couldn't find user");
            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Couldn't Load Second Screen");
            }
        }
    }
    public void onRegisterClick(ActionEvent actionEvent) {

        try {
            Stage stage = (Stage) username.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Sign Up");
            stage.setScene(scene);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Couldn't Load Second Screen");
        }
    }
}
