package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
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
  private void onAddIncome() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) addIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onAddExpense() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) addExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onDeleteIncome() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) deleteIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onDeleteExpense() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) deleteExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onViewIncome() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) viewIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onViewExpense() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) viewExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  @FXML
  private void onGenerateReport() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("report.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) generateReportButton.getScene().getWindow();
    currentStage.close();
  }
}
