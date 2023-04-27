package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
public class Register {
  
  @FXML
  private Button submitButton;
  @FXML
  private Button goBackButton;
  @FXML
  private TextField emailField;
  @FXML
  private TextField passwordField;
  @FXML
  private TextField confirmPasswordField;
  
  @FXML
  private void onSubmit() throws IOException {
    // Get the user input from the text fields
    String email = emailField.getText();
    String password = passwordField.getText();
    String confirmPassword = confirmPasswordField.getText();
    
    // Validate the user input
    if (!password.equals(confirmPassword)) {
      // Passwords do not match, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match.");
      alert.showAndWait();
      return;
    }
    // Generate a unique filename for the new user's CSV file
    File file = new File(email + ".csv");
    // Check if a CSV file with the same email already exists
    if (file.exists()) {
      // Display error message if file already exists
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Registration Failed");
      alert.setContentText("A user with the same email already exists.");
      alert.showAndWait();
      return;
    }
    // Create new CSV file with email as name
    FileWriter writer = new FileWriter(file);
    writer.write("Email: " + email);
    writer.write("\nPassword: " + password);
    writer.flush();
    writer.close();


//    // Write the new user's data to a CSV file
//    try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
//      // Write the header row
//      String[] header = {"email", "password"};
//      writer.writeNext(header);
//
//      // Write the user data
//      String[] data = {newUser.getEmail(), newUser.getPassword()};
//      writer.writeNext(data);
//    }
    
    // Show a success message and close the window
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "registered successfully.");
    alert.showAndWait();
    
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) submitButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onGoBack() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
