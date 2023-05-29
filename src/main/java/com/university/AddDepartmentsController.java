package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddDepartmentsController {

    ArrayList<Department> departments = new ArrayList<Department>();
    
    @FXML
    private Button addLabsButton;

    @FXML
    private Button addMoreDepButton;

    @FXML
    private TextField departmentNameField;

    @FXML
    private VBox fieldsHolder;

    @FXML
    private TextField hodGradeField;

    @FXML
    private TextField hodNameField;

    @FXML
    void addLabsButtonClicked(ActionEvent event) throws IOException {
        saveToFile();
        App.setRoot("addLabs");
    }

    @FXML
    void addMoreDepButtonClicked(ActionEvent event) {
        addtoArrayList();
    }

    private void saveToFile() {
        addtoArrayList();
        try {
            String filePath = "university.txt";
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Departments: \n");

            for (Department department : departments) {
                bufferedWriter.write("Name: " + department.getDepartmentName() + " | HOD Name: "
                        + department.getHodName() + " | HOD Grade: " + department.getHodGrade() + "\n");
            }

            bufferedWriter.write("\n");
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved To File");
            alert.setContentText("Departments have been saved to file successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR WHILE SAVING.");
            alert.setContentText("Could not save departments to file.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void addtoArrayList() {
        String depName = departmentNameField.getText();
        String hodName = hodNameField.getText();
        String hodGrade = hodGradeField.getText();

        if (depName.isEmpty() || hodName.isEmpty() || hodGrade.isEmpty()) {
            System.out.println("Please fill all the fields.");

            if (depName.isEmpty()) {
                departmentNameField.setStyle("-fx-border-color: red");
            }
            if (hodName.isEmpty()) {
                hodNameField.setStyle("-fx-border-color: red");
            }
            if (hodGrade.isEmpty()) {
                hodGradeField.setStyle("-fx-border-color: red");
            }

            return;
        } else {
            HOD hod = new HOD(new Employee(hodName, hodGrade));
            Department department = new Department(depName, hod);
            departments.add(department);
            System.out.println("Department Added to ArrayList.");
        }
    }

}
