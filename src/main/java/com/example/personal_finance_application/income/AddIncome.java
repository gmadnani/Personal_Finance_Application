package com.example.personal_finance_application.income;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class AddIncome {
  @FXML
  private Button saveButton;
  
  @FXML
  private Button cancelButton;
  
  @FXML
  private void onSave() {
    Stage currentStage = (Stage) saveButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onCancel() {
    Stage currentStage = (Stage) cancelButton.getScene().getWindow();
    currentStage.close();
  }
}
