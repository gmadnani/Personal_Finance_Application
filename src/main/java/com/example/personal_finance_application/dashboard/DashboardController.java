package com.example.personal_finance_application.dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class DashboardController {
  @FXML
  private Button addIncomeButton;
  @FXML
  private Button addExpenseButton;
  @FXML
  private Button deleteIncomeButton;
  @FXML
  private Button deleteExpenseButton;
  @FXML
  private Button viewIncomeButton;
  @FXML
  private Button viewExpenseButton;
  @FXML
  private Button generateReportButton;
  
  @FXML
  private void onAddIncome() {
    
    Stage currentStage = (Stage) addIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onAddExpense() {
    
    Stage currentStage = (Stage) addExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onDeleteIncome() {
    
    Stage currentStage = (Stage) deleteIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onDeleteExpense() {
    
    Stage currentStage = (Stage) deleteExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onViewIncome() {
    
    Stage currentStage = (Stage) viewIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onViewExpense() {
    
    Stage currentStage = (Stage) viewExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onGenerateReport() {
    
    Stage currentStage = (Stage) generateReportButton.getScene().getWindow();
    currentStage.close();
  }
}
