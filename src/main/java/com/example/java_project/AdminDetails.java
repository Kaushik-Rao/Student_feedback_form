package com.example.java_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class AdminDetails {



    @FXML
    public void view_responses(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("View_responses_details");
    }
    @FXML
    public void updateAdmin(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("Update_Admin_details");

    }
    @FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("password_field");

    }

}