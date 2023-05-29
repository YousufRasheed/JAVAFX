package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddLabsController {

    ArrayList<Lab> labs = new ArrayList<Lab>();

    Boolean hasProjector = false;

    @FXML
    private Button addComputersButton;

    @FXML
    private Button addMoreDepButton;

    @FXML
    private VBox fieldsHolder;

    @FXML
    private CheckBox hasProjectorCheck;

    @FXML
    private TextField inchargeGradeField;

    @FXML
    private TextField inchargeNameField;

    @FXML
    private TextField labNameField;

    @FXML
    void addComputersButtonClicked(ActionEvent event) throws IOException {
        saveToFile();
        App.setRoot("addComputers");
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

            bufferedWriter.write("Labs: \n");

            for (Lab lab : labs) {
                if (lab.hasProjector) {
                    bufferedWriter.write("Name: " + lab.getLabName() + " | Incharge Name: " + lab.getLabInchargeName() + " | Incharge Grade: " + lab.getLabInchargeGrade() + " | Has Projector: Yes\n");
                } else {
                    bufferedWriter.write("Name: " + lab.getLabName() + " | Incharge Name: " + lab.getLabInchargeName() + " | Incharge Grade: " + lab.getLabInchargeGrade() + " | Has Projector: No\n");
                }
            }

            bufferedWriter.write("\n");
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved To File");
            alert.setContentText("Labs have been saved to file successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR WHILE SAVING.");
            alert.setContentText("Could not save Labs to file.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void addtoArrayList() {
        String labName = labNameField.getText();
        String inchargeName = inchargeNameField.getText();
        String inchargeGrade = inchargeGradeField.getText();
        Boolean hasProjector = hasProjectorCheck.isSelected();

        if (labName.isEmpty() || inchargeName.isEmpty() || inchargeGrade.isEmpty()) {
            System.out.println("Please fill all the fields.");

            if (labName.isEmpty()) {
                labNameField.setStyle("-fx-border-color: red");
            }
            if (inchargeName.isEmpty()) {
                inchargeNameField.setStyle("-fx-border-color: red");
            }
            if (inchargeGrade.isEmpty()) {
                inchargeGradeField.setStyle("-fx-border-color: red");
            }

            return;
        } else {
            LabStaff incharge = new LabStaff(new Employee(inchargeName, inchargeGrade));
            Lab lab = new Lab(labName, incharge, hasProjector);
            labs.add(lab);
            System.out.println("Lab Added to ArrayList.");
        }
    }

}
