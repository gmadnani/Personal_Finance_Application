//---------------------------------------------------------------------------
//
// DeleteExpense
// Deleting expenses from csv
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class allows to select expenses from the table which is to be deleted
// from the csv.
//
// Assumptions:
// An "are you sure" message is displayed when delete button is pressed
//

package com.example.personal_finance_application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DeleteExpense<T extends ReportEntry> {
  @FXML
  private TableView<T> expenseTable;
  @FXML
  private Button goBackButton;
  @FXML
  private Button deleteButton;
  
  private List<T> expenseData = new ArrayList<>();
  
  ///////////////////////////////////////////////////////////////////
/// initialize (initializes the delete expense page)              ///
///////////////////////////////////////////////////////////////////
  public void initialize() throws IOException {
    updateExpense();
    chooseExpense();
  }
  
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
/// chooseExpense (allows the user to select the expense data)    ///
///////////////////////////////////////////////////////////////////
  private void chooseExpense() {
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
/// onDeleteExpense (deletes selected expense data)               ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onDeleteExpense() {
    ObservableList<T> selectedEntries = expenseTable.getSelectionModel().getSelectedItems();
    // show confirmation dialog
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the selected entries?");
    alert.setTitle("Delete Entries");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      try {
        // Write updated data to file
        File file = new File(Login.getCurrentUser().getEmail() + ".csv");
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> remainingLines = new ArrayList<>();
        for (String line : lines) {
          Boolean found = false;
          for (T entry : selectedEntries) {
            double amount = entry.getAmount();
            String category = entry.getCategory();
            LocalDate date = entry.getDate();
            String notes = entry.getNotes();
            String lineToCheck = entry.getType() + "," + amount + "," + category + "," + date + "," + notes;
            if (line.equals(lineToCheck)) {
              found = true;
            }
          }
          String[] values = line.split(",");
          String type = values[0];
          
          if ((type.equals("Email") || type.equals("Password") || type.equals("Income") || type.equals("Expense")) && !found) {
            remainingLines.add(line);
          }
        }
        Files.write(file.toPath(), remainingLines);
      } catch (IOException e) {
        e.printStackTrace();
      }
      expenseData.removeAll(selectedEntries);
      expenseTable.getItems().clear();
      expenseTable.setItems(FXCollections.observableArrayList(expenseData));
    }
  }
  
  ///////////////////////////////////////////////////////////////////
/// onGoBack (navigates the page to dashboard)                    ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onGoBack() throws IOException {
    //navigate to dashboard
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // Close the delete expense view
    Stage currentStage = (Stage) goBackButton.getScene().getWindow();
    currentStage.close();
  }
}
