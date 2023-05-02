//---------------------------------------------------------------------------
//
// ViewExpense
// Viewing Expenses for the application
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class reads all and expenses in the csv and then arranges in a table
// format which is to be displayed
//
// Assumptions:
// only expenses are displayed
//

package com.example.personal_finance_application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ViewExpense<T extends ReportEntry> {
  @FXML
  private TableView<T> expenseTable;
  @FXML
  private Button goBackButton;
  
  ///////////////////////////////////////////////////////////////////
/// initialize (initializes the view expense page)                ///
///////////////////////////////////////////////////////////////////
  public void initialize() throws IOException {
    updateExpense();
    showExpense();
  }
  
  private List<T> expenseData = new ArrayList<>();
  
  ///////////////////////////////////////////////////////////////////
/// updateExpense (update the expense data in the csv)            ///
///////////////////////////////////////////////////////////////////
  public void updateExpense() throws IOException {
    File file = new File(Login.getCurrentUser().getEmail() + ".csv");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] values = line.split(",");
      String type = values[0];
      if (type.equals("Expense")) {
        double amount = Double.parseDouble(values[1].trim());
        String category = values[2];
        LocalDate date = LocalDate.parse(values[3]);
        String notes = values[4];
        T entry = (T) new ReportEntry(type, amount, category, date, notes);
        expenseData.add(entry);
      }
    }
    reader.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// showExpense (show the expense data in the table format)       ///
///////////////////////////////////////////////////////////////////
  private void showExpense() {
    TableColumn<T, String> typeCol = new TableColumn<>("Type");
    typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    
    TableColumn<T, Double> amountCol = new TableColumn<>("Amount");
    amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
    
    TableColumn<T, String> categoryCol = new TableColumn<>("Category");
    categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
    
    TableColumn<T, LocalDate> dateCol = new TableColumn<>("Date");
    dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    
    TableColumn<T, String> notesCol = new TableColumn<>("Notes");
    notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));
    
    expenseTable.getColumns().setAll(typeCol, amountCol, categoryCol, dateCol, notesCol);
    
    ObservableList<T> data = FXCollections.observableArrayList();
    data.addAll(expenseData);
    expenseTable.setItems(data);
  }
  
  ///////////////////////////////////////////////////////////////////
/// onGoBack (navigates the page to dashboard)                    ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onGoBack() throws IOException {
    // navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // Close the view expense view
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
