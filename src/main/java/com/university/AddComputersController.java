package com.university;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddComputersController {

    ArrayList<Pc> pcList = new ArrayList<>();
    ArrayList<Lab> labs = new ArrayList<Lab>();
    
    @FXML
    private Button closeButton;

    @FXML
    private Button addMoreDepButton;

    @FXML
    private VBox fieldsHolder;

    @FXML
    private TextField systemHddSizeField;

    @FXML
    private TextField systemIDField;

    @FXML
    private TextField systemNameField;

    @FXML
    private TextField systemRamField;

    @FXML
    private TextField systemScreenField;

    @FXML
    private TextField systemSpeedField;

    @FXML
    void closeButtonClicked(ActionEvent event) {
        saveToFile();

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
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

            bufferedWriter.write("Computers: \n");

            for (Pc pc : pcList ) {
                bufferedWriter.write(pc.getSystemDetails());
            }

            bufferedWriter.write("\n");
            bufferedWriter.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved To File");
            alert.setContentText("Computers have been saved to file successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR WHILE SAVING.");
            alert.setContentText("Could not save Computers to file.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void addtoArrayList() {
        String sysId = systemIDField.getText();
        String sysName = systemNameField.getText();
        String sysSpeed = systemSpeedField.getText();
        String sysRam = systemRamField.getText();
        String sysHddSize = systemHddSizeField.getText();
        String sysScreen = systemScreenField.getText();

        if (sysId.isEmpty() || sysName.isEmpty() || sysSpeed.isEmpty() || sysRam.isEmpty() || sysHddSize.isEmpty()
                || sysScreen.isEmpty()) {
            System.out.println("Please fill all the fields.");

            if (sysId.isEmpty()) {
                systemIDField.setStyle("-fx-border-color: red");
            }
            if (sysName.isEmpty()) {
                systemNameField.setStyle("-fx-border-color: red");
            }
            if (sysSpeed.isEmpty()) {
                systemSpeedField.setStyle("-fx-border-color: red");
            }
            if (sysRam.isEmpty()) {
                systemRamField.setStyle("-fx-border-color: red");
            }
            if (sysHddSize.isEmpty()) {
                systemHddSizeField.setStyle("-fx-border-color: red");
            }
            if (sysScreen.isEmpty()) {
                systemScreenField.setStyle("-fx-border-color: red");
            }
            
            return;
        } else {
            Pc pc = new Pc(sysId, sysName, sysSpeed, sysRam, sysHddSize, sysScreen);
            pcList.add(pc);
            System.out.println("Lab Added to ArrayList.");
        }
    }
}
