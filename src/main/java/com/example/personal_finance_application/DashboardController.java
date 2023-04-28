package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class DashboardController {
  @FXML
  private Label incomeLabel;
  @FXML
  private Label expenseLabel;
  @FXML
  private Label savingsLabel;
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
  
  public void initialize() throws IOException {
    updateTotals();
  }
  
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
  
  private void updateTotals() throws IOException {
    // Create lists to store income and expense data
    List<String> incomeData = new ArrayList<>();
    List<String> expenseData = new ArrayList<>();
    double totalIncome = 0;
    double totalExpense = 0;
    double totalSavings;
    // Load the CSV file
    File file = new File(Login.getCurrentUser().getEmail() + ".csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    // Read the CSV file line by line
    String line;
    while ((line = reader.readLine()) != null) {
      String[] values = line.split(",");
      String type = values[0].trim();
      // Store income and expense data in separate lists
      if (type.equals("Income")) {
        incomeData.add(line);
      } else if (type.equals("Expense")) {
        expenseData.add(line);
      }
    }
    // Calculate the total income
    for (String income : incomeData) {
      String[] values = income.split(",");
      double amount = Double.parseDouble(values[1].trim());
      totalIncome += amount;
    }
    // Calculate the total expense
    for (String expense : expenseData) {
      String[] values = expense.split(",");
      double amount = Double.parseDouble(values[1].trim());
      totalExpense += amount;
    }
    // Calculate the total savings
    totalSavings = totalIncome - totalExpense;
    if (totalSavings < 0) {
      totalSavings = 0;
    }
    // update labels
    incomeLabel.setText(String.format("%.2f", totalIncome));
    expenseLabel.setText(String.format("%.2f", totalExpense));
    savingsLabel.setText(String.format("%.2f", totalSavings));
  }
}
