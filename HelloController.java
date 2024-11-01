package com.example.hrmangagementdivya;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    public Label username;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("2ndview.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("NewPage");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) username.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        welcomeText.setText("Welcome!");
    }
}