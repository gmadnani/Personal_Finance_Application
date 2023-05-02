//---------------------------------------------------------------------------
//
// Login
// Logging in your account
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class reads your inputs from the input fields and check if those
// credentials exists in the csv
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
public class Login {
  public static User currentUser;
  @FXML
  private TextField emailField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button submitButton;
  @FXML
  private Button goBackButton;
  
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
    String email = emailField.getText();
    String password = passwordField.getText();
    // Find the user's CSV file
    File file = new File(email + ".csv");
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
    if (!file.exists()) {
      // Display error message if file does not exist
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Login Failed");
      alert.setContentText("User not found.");
      alert.showAndWait();
      return;
    }
    // Read the user's data from the CSV file
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String data = reader.readLine();
    String[] dataEmail = data.split(",");
    String storedEmail = dataEmail[1];
    data = reader.readLine();
    String[] dataPassword = data.split(",");
    String storedPassword = dataPassword[1];
    reader.close();
    // Check if the password matches the one in the file
    if (!password.equals(storedPassword)) {
      // Display error message if password is incorrect
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText("Login Failed");
      alert.setContentText("Incorrect password.");
      alert.showAndWait();
      return;
    }
    // Login successful, show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successful.");
    alert.showAndWait();
    currentUser = new User();
    currentUser.setEmail(storedEmail);
    // if login is successful, navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current login window
    Stage currentStage = (Stage) submitButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onGoBack (navigates the page to welcome)                      ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onGoBack() throws IOException {
    // navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current login window
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// getCurrentUser (get the user data)                            ///
///////////////////////////////////////////////////////////////////
  public static User getCurrentUser() {
    return currentUser;
  }
}
