package com.example.personal_finance_application.welcome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class WelcomeController {
  @FXML
  private Button loginButton;
  
  @FXML
  private Button registerButton;
  
  @FXML
  private void onLogin() {
    // code to validate login credentials
    
    // if login is successful, navigate to dashboard
    
    // close the current welcome window
    Stage currentStage = (Stage) loginButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onRegister() {
    // code to navigate to register page
    
    // close the current welcome window
    Stage currentStage = (Stage) registerButton.getScene().getWindow();
    currentStage.close();
  }
}
