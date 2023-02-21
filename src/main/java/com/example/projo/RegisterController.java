package com.example.projo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private ImageView sunImageView;
    @FXML
    private ImageView calenderImageView;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        File sunFile = new File("Images/reg.jpg");
        Image sunImage = new Image(sunFile.toURI().toString());
        sunImageView.setImage(sunImage);

        File calenderFile = new File("Images/reg_1.png");
        Image calenderImage = new Image(calenderFile.toURI().toString());
        calenderImageView.setImage(calenderImage);
    }

    public void registerButtonOnAction(ActionEvent event) {
        if (setPassword.getText().equals(confirmPassword.getText())) {
            registerUser();
            confirmPasswordLabel.setText("");

        } else {
            confirmPasswordLabel.setText("Password does not match.");

        }

    }
    public void closeButtonOnAction (ActionEvent e){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    private void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPassword.getText();

        String insertFields = "INSERT INTO user_account(lastname, firstname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("User has been registered successively");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
