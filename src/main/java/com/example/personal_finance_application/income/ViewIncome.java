package com.example.personal_finance_application.income;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class ViewIncome {
  
  @FXML
  private Button goBackButton;
  
  @FXML
  private void onGoBack() {
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
