package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUniversityController {

    @FXML
    private TextField universityNameField;

    @FXML
    private Button addCampusButton;

    @FXML
    private Button saveToFileButton;

    University university;

    public void initialize() {
        university = new University("");
    }

    @FXML
    private void addCampusButtonClicked() throws IOException {
        String universityName = universityNameField.getText();
        university.name = universityName;
        System.out.println(university.name + " added to university.");
        saveTofile();
        App.setRoot("addCampuses");
    }

    @FXML
    private void saveToFileClicked() {
        saveTofile();
    }

    private void saveTofile() {
        try {
            String filePath = "university.txt";
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("University Name: " + university.name + "\n\nCampuses: \n");
            bufferedWriter.close();
            System.out.println("University name saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Could not save University name to file.");
            e.printStackTrace();
        }
    }
}
