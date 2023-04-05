package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Map;
public class ReportController {
  @FXML
  private TextArea reportTextArea;
  
  private TransactionManager transactionManager;
  
  public void setTransactionManager(TransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }
  
  public void initialize() {
    String report = String.format("Total spending: $%.2f\n\nCategory spending:\n", transactionManager.getTotalSpending());
    Map<String, Double> categorySpending = transactionManager.getCategorySpending();
    for (String category : categorySpending.keySet()) {
      double amount = categorySpending.get(category);
      report += String.format("%s: $%.2f\n", category, amount);
    }
    reportTextArea.setText(report);
  }
  
  @FXML
  private Label welcomeText;
  
  @FXML
  protected void onButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}
