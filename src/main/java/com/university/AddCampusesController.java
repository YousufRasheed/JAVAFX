package com.university;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddCampusesController {

    ArrayList<Campus> campuses = new ArrayList<Campus>();

    @FXML
    private Button addDepartmentButton;

    @FXML
    private Button addMoreCampusButton;

    @FXML
    private TextField campusAddressField;

    @FXML
    private TextField campusNameField;

    @FXML
    private TextField directorGradeField;

    @FXML
    private TextField directorNameField;

    @FXML
    void addDepartmentButtonClicked(ActionEvent event) throws IOException {
        saveToFile();
        App.setRoot("addDepartments");
    }

    @FXML
    void addMoreCampusButtonClicked(ActionEvent event) {
        addCampustoArrayList();
    }

    private void saveToFile() {
        addCampustoArrayList();
        try {
            String filePath = "university.txt";
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Campus campus : campuses) {
                bufferedWriter.write("Name: " + campus.name + " | Address: " + campus.address + " | Director Name: "
                        + campus.getDirectorName() + " | Director Grade: " + campus.getDirectorGrade() + "\n");
            }

            bufferedWriter.write("\n");
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved To File");
            alert.setContentText("Campuses have been saved to file successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            System.out.println("Could not save campuses to file.");
            e.printStackTrace();
        }
    }

    private void addCampustoArrayList() {
        String campAddress = campusAddressField.getText();
        String campName = campusNameField.getText();
        String dirName = directorNameField.getText();
        String dirGrade = directorGradeField.getText();

        if (campAddress.isEmpty() || campName.isEmpty() || dirName.isEmpty() || dirGrade.isEmpty()) {
            System.out.println("Please fill all the fields.");

            if (campAddress.isEmpty()) {
                campusAddressField.setStyle("-fx-border-color: red");
            }
            if (campName.isEmpty()) {
                campusNameField.setStyle("-fx-border-color: red");
            }
            if (dirName.isEmpty()) {
                directorNameField.setStyle("-fx-border-color: red");
            }
            if (dirGrade.isEmpty()) {
                directorGradeField.setStyle("-fx-border-color: red");
            }

            return;
        } else {
            Director director = new Director(new Employee(dirName, dirGrade));
            Campus campus = new Campus(campName, campAddress, director);
            campuses.add(campus);
            System.out.println("Campus Added to ArrayList.");
        }
    }

}
