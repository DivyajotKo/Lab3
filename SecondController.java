package com.example.hrmangagementdivya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondController {
    public Button logout;
    public Button Exit;
    public Button adminpage;
    public Button Employee;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("adminview.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Login");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) adminpage.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logoutClick(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("HEHE");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) logout.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExitClick(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("exitview.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Employee Page");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) Employee.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EmployeeClick(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("employeeview.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("See You");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) Exit.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}