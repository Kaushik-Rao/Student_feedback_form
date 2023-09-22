package com.example.java_project;

import javafx.fxml.FXML;


import java.io.IOException;

public class HelloController {


    @FXML
    protected void fill_form() throws IOException {
        HelloApplication.setRoot("Student_login_details");
    }
    @FXML
    protected void admin_login() throws IOException {
        HelloApplication.setRoot("password_field");
    }
}