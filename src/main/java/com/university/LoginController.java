package com.university;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {

    private static final String FILE_PATH = "logins.txt";

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginButtonClicked() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (validateUser(username, password)) {

            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
            App.setRoot("addUniversity");

        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    private void signUpButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (createUser(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Sign Up Successful", "Account created successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Sign Up Failed", "Username already exists.");
        }
    }

    private boolean validateUser(String username, String password) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedUsername = parts[0];
                String storedPassword = parts[1];
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean createUser(String username, String password) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedUsername = parts[0];
                if (username.equals(storedUsername)) {
                    scanner.close();
                    return false;
                }
            }
            scanner.close();

            FileWriter writer = new FileWriter(file, true);
            writer.write(username + "," + password + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
