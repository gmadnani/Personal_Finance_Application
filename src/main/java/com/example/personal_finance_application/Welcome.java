package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
public class Welcome {
  @FXML
  private Button loginButton;
  
  @FXML
  private Button registerButton;
  
  @FXML
  private void onLogin() throws IOException {
    // code to validate login credentials
    
    // if login is successful, navigate to dashboard
    
    // close the current welcome window
    
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) loginButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onRegister() throws IOException {
    // code to navigate to register page
    
    // close the current welcome window
    
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) registerButton.getScene().getWindow();
    currentStage.close();
  }
}
