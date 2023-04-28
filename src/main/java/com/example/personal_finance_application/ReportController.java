package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ReportController {
  @FXML
  private Button goBackButton;
  
  public void initialize() throws IOException {
    updateReport();
  }
  
  private void updateReport() throws IOException {
    // Create lists to store income and expense data
    List<String> incomeData = new ArrayList<>();
    List<String> expenseData = new ArrayList<>();
    double totalIncome = 0;
    double totalExpense = 0;
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
      String category = values[2];
      LocalDate date = LocalDate.parse(values[3]);
      String notes = values[4];
    }
    // Calculate the total expense
    for (String expense : expenseData) {
      String[] values = expense.split(",");
      double amount = Double.parseDouble(values[1].trim());
      String category = values[2];
      LocalDate date = LocalDate.parse(values[3]);
      String notes = values[4];
    }
    // Calculate the total income
    totalIncome = incomeData.stream()
        .map(incomeLine -> incomeLine.split(","))
        .mapToDouble(values -> Double.parseDouble(values[1].trim()))
        .sum();
    // Calculate the total expense
    totalExpense = expenseData.stream()
        .map(expenseLine -> expenseLine.split(","))
        .mapToDouble(values -> Double.parseDouble(values[1].trim()))
        .sum();
    // Print the totals to the console
    System.out.println("Total Income: " + totalIncome);
    System.out.println("Total Expense: " + totalExpense);
  }
  
  @FXML
  private void onGoBack() throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
