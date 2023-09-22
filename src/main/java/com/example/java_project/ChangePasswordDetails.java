package com.example.java_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;
import javafx.scene.control.TextField;
import Connectivity.connectionClass;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangePasswordDetails {
    @FXML
    public TextField current_username;
    public javafx.scene.control.PasswordField current_password;
    public PasswordField new_password;

    public Label success;

    @FXML
    public javafx.scene.control.Button save_button;
    @FXML
    protected void save_password() throws SQLException {
        Window owner = save_button.getScene().getWindow();

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = connection.createStatement();
        String user = current_username.getText();
        String current_passwordText = current_password.getText();
        String newPass = new_password.getText();
        String sql2 =  "SELECT * FROM USERLOGIN WHERE USERNAME = '"+user+"' AND PASSWORD = '"+current_passwordText+"';";

        ResultSet result = statement.executeQuery(sql2);
        if(result.next()){

            String sql ="UPDATE USERLOGIN SET PASSWORD ='"+newPass+"' WHERE USERNAME = '"+user+"';";
            statement.executeUpdate(sql);
            success.setText("Password has been changed!!");

        }
        else{
            showAlert(Alert.AlertType.ERROR, owner, "Password Error!",
                    "Wrong password");
            return;

        }



    }
    private static void showAlert(Alert.AlertType alertType, Window owner,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    @FXML
    protected void return_1() throws SQLException, IOException {
        HelloApplication.setRoot("Update_Admin_details");
    }



}
