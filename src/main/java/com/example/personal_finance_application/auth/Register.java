package com.example.personal_finance_application.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class Register {
  
  @FXML
  private Button submitButton;
  @FXML
  private Button goBackButton;
  
  @FXML
  private void onSubmit() {
    Stage currentStage = (Stage) submitButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onGoBack() {
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
