package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
public class AddIncome {
  @FXML
  private TextField categoryField;
  @FXML
  private TextField amountField;
  @FXML
  private DatePicker dateField;
  @FXML
  private TextArea notesField;
  @FXML
  private Button saveButton;
  @FXML
  private Button cancelButton;
  
  @FXML
  private void onSave() throws IOException {
    // Get the income data from the user input fields
    double amount = Double.parseDouble(amountField.getText());
    String category = categoryField.getText();
    LocalDate date = dateField.getValue();
    String notes = notesField.getText();
    // Add the income to the user's CSV file
    File file = new File(Login.getCurrentUser().getEmail() + ".csv");
    FileWriter writer = new FileWriter(file, true);
    writer.write("\nIncome," + amount + "," + category + "," + date + "," + notes);
    writer.close();
    // Show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Income saved.");
    alert.showAndWait();
    // if adding income is successful, navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current login window
    Stage currentStage = (Stage) saveButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onCancel() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) cancelButton.getScene().getWindow();
    currentStage.close();
  }
}
