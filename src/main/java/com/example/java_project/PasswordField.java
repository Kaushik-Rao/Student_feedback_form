package com.example.java_project;

import Connectivity.connectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PasswordField {
    @FXML
    public javafx.scene.control.PasswordField password;
    public TextField username;
    @FXML
    private Button submit_button;



    @FXML
    protected void loginorsignup() throws SQLException, IOException {

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();
        Window owner = submit_button.getScene().getWindow();
        String user = username.getText();
        String pass = password.getText();
        if (user.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Username error!",
                    "Please enter your username");
            return;
        }
        if (pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Password error!",
                    "Please enter a password");
            return;
        }
        if(user.equals("kaushik") && pass.equals("420")){
            HelloApplication.setRoot("Admin_details");
            return;
        }
        Statement statement = connection.createStatement();
////        statement.executeUpdate(sql);
        String sql2 =  "SELECT * FROM USERLOGIN WHERE USERNAME = '"+user+"';";
////SELECT COMMAND
        ResultSet result = statement.executeQuery(sql2);
        if(result.next()){

            System.out.println(result.getString("password"));

            if(result.getString("password").equals(pass)){
                //change Screen

                System.out.println("Logined");
                HelloApplication.setRoot("Admin_details");
            }
            else {
                showAlert(Alert.AlertType.ERROR, owner, "Password Error!",
                        "Wrong password");
            }



        }



    }
    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner,String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }


}
