package com.example.java_project;

import Connectivity.connectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ResponsePage implements Initializable {
    @FXML
    public RadioButton first;
    public RadioButton second;


    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        first.setToggleGroup(group);
        second.setToggleGroup(group);
    }


 }