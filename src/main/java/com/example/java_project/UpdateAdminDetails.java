package com.example.java_project;

import javafx.event.ActionEvent;

import java.io.IOException;

public class UpdateAdminDetails {
    public void change_username(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("Change_Username_details");
    }

    public void change_password(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("Change_password_details");
    }
    public void add_admin(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("Add_Admin_details");
    }
    public void return_admindetails(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("Admin_details");
    }
}
