//---------------------------------------------------------------------------
//
// AddExpense
// Adding expense to csv
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class takes in the inputs from the input fields and save it in the
// csv as an Expense
//
// Assumptions:
// All the fields are typed in and are in the right format
//

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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;
public class AddExpense {
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
  
  ///////////////////////////////////////////////////////////////////
/// onSave (save to csv)                                          ///
/// Input : values of the input fields                            ///
/// Output: All outputs are alerts based on different conditions  ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onSave() throws IOException {
    // Get the expense data from the user input fields
    String amountText = amountField.getText();
    String category = categoryField.getText();
    LocalDate date = dateField.getValue();
    String notes = notesField.getText();
    
    // Check that no field is empty
    if (amountText.isEmpty() || category.isEmpty() || date == null || notes.isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
      alert.showAndWait();
      return;
    }
    
    // Validate the expense data
    double amount;
    try {
      amount = Double.parseDouble(amountText);
    } catch (NumberFormatException e) {
      // Amount is not a number, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Amount must be a number.");
      alert.showAndWait();
      return;
    }
    
    try {
      date = dateField.getValue();
    } catch (DateTimeException e) {
      // Date is not in a valid format, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Date must be in a valid format.");
      alert.showAndWait();
      return;
    }
    // Add the expense to the user's CSV file
    File file = new File(Login.getCurrentUser().getEmail() + ".csv");
    FileWriter writer = new FileWriter(file, true);
    writer.write("\nExpense," + amount + "," + category + "," + date + "," + notes);
    writer.close();
    // Show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Expense saved.");
    alert.showAndWait();
    // if adding expense is successful, navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current add expense window
    Stage currentStage = (Stage) saveButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onCancel ( cancel the add expense and routes to dashboard)    ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onCancel() throws IOException {
    // navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current add expense window
    Stage currentStage = (Stage) cancelButton.getScene().getWindow();
    currentStage.close();
  }
}
