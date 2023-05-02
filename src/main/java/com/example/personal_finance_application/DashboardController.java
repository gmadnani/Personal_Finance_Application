//---------------------------------------------------------------------------
//
// DashboardController
// Main dashboard for the application
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class routes to all the necessary pages of income, expense and report.
// It also calculates the total income, expense and savings in order to be
// displayed on the dashboard page
//
// Assumptions:
// savings cannot go less than 0
//

package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
  private Label nameLable;
  @FXML
  private Label incomeLabel;
  @FXML
  private Label expenseLabel;
  @FXML
  private Label savingsLabel;
  @FXML
  private Button logoutButton;
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
  
  ///////////////////////////////////////////////////////////////////
/// initialize (initialize the dashboard page)                    ///
///////////////////////////////////////////////////////////////////
  public void initialize() throws IOException {
    File file = new File(Login.getCurrentUser().getEmail() + ".csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    // Read the CSV file line by line
    String line;
    while ((line = reader.readLine()) != null) {
      String[] values = line.split(",");
      String type = values[0].trim();
      // Store income and expense data in separate lists
      if (type.equals("Name")) {
        nameLable.setText("Welcome " + values[1]);
        break;
      }
    }
    updateTotals();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onAddIncome (route to add income page)                        ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onAddIncome() throws IOException {
    // navigate to add income
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) addIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onAddExpense (route to add expense page)                        ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onAddExpense() throws IOException {
    // navigate to add expense
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) addExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onDeleteIncome (route to delete income page)                        ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onDeleteIncome() throws IOException {
    // navigate to delete income
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) deleteIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onDeleteExpense (route to delete expense page)                ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onDeleteExpense() throws IOException {
    // navigate to delete expense
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) deleteExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onViewIncome (route to view income page)                        ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onViewIncome() throws IOException {
    // navigate to view income
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewIncome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) viewIncomeButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onViewExpense (route to view expense page)                    ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onViewExpense() throws IOException {
    // navigate to view expense
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewExpense.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) viewExpenseButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onGenerateReport (route to generate report page)              ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onGenerateReport() throws IOException {
    // navigate to report
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("report.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current dashboard window
    Stage currentStage = (Stage) generateReportButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////////
/// updateTotals (calculates the total income, expense and savings)   ///
///////////////////////////////////////////////////////////////////////
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
    totalIncome = incomeData.stream()
        .map(incomeLine -> incomeLine.split(","))
        .mapToDouble(values -> Double.parseDouble(values[1].trim()))
        .sum();
    // Calculate the total expense
    totalExpense = expenseData.stream()
        .map(expenseLine -> expenseLine.split(","))
        .mapToDouble(values -> Double.parseDouble(values[1].trim()))
        .sum();
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
  
  ///////////////////////////////////////////////////////////////////
/// onLogout (logs out the user)                                  ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onLogout() throws IOException {
    // Reset the current user
    Login.currentUser = null;
    // Show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Logout successful.");
    alert.showAndWait();
    // Navigate to the welcome view
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // Close the dashboard view
    Stage currentStage = (Stage) logoutButton.getScene().getWindow();
    currentStage.close();
  }
}
