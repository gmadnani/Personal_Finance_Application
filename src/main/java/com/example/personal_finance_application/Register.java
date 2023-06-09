//---------------------------------------------------------------------------
//
// Register
// registering an account
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class reads your inputs from the input fields and creates those
// credentials in the csv
//
// Assumptions:
// all the fields are typed in
//

package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
  private TextField nameField;
  @FXML
  private TextField emailField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private PasswordField confirmPasswordField;
  
  private static final String EMAIL_PATTERN =
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
          + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  private static final String PASSWORD_PATTERN =
      "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
  
  ///////////////////////////////////////////////////////////////////
/// onSubmit (save to csv)                                         ///
/// Input : values of the input fields                            ///
/// Output: All outputs are alerts based on different conditions  ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onSubmit() throws IOException {
    // Get the user input from the text fields
    String name = nameField.getText();
    String email = emailField.getText();
    String password = passwordField.getText();
    String confirmPassword = confirmPasswordField.getText();
    // Check that no field is empty
    if (name.isEmpty() || email.isEmpty() || password == null || confirmPassword.isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
      alert.showAndWait();
      return;
    }
    // Validate the user input
    if (!password.equals(confirmPassword)) {
      // Passwords do not match, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match.");
      alert.showAndWait();
      return;
    }
    if (!email.matches(EMAIL_PATTERN)) {
      // Email is not in a valid format, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Email is not in a valid format.");
      alert.showAndWait();
      return;
    }
    if (!password.matches(PASSWORD_PATTERN)) {
      // Password is not strong enough, show an error message and return
      Alert alert = new Alert(Alert.AlertType.ERROR, "Password should be at least 8 characters and include at least one uppercase letter, one lowercase letter, one digit, and one special character.");
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
    writer.write("Email," + email);
    writer.write("\nPassword," + password);
    writer.write("\nName," + name);
    writer.flush();
    writer.close();
    //Register successful, show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration successfully.");
    alert.showAndWait();
    // if register is successful, navigate to login
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current register window
    Stage currentStage = (Stage) submitButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onGoBack (navigates the page to welcome)                      ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onGoBack() throws IOException {
    // navigate to welcome
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current register window
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
