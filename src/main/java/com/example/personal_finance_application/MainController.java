package com.example.personal_finance_application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainController {
  @FXML
  private TableView<Transaction> transactionsTable;
  
  @FXML
  private TableColumn<Transaction, String> categoryColumn;
  
  @FXML
  private TableColumn<Transaction, Double> amountColumn;
  
  @FXML
  private TableColumn<Transaction, LocalDate> dateColumn;
  
  private TransactionManager transactionManager;
  
  public void initialize() {
    transactionManager = new TransactionManager();
    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    transactionsTable.setItems(FXCollections.observableArrayList(transactionManager.getTransactions()));
  }
  
  @FXML
  public void handleAddTransaction() throws IOException {
    // Code to show a dialog for adding a new transaction and update the table view
    // Example:
    FXMLLoader loader = new FXMLLoader(getClass().getResource("add_transaction.fxml"));
    Parent root = loader.load();
    AddTransactionController controller = loader.getController();
    controller.setTransactionManager(transactionManager);
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.showAndWait();
    transactionsTable.setItems(FXCollections.observableArrayList(transactionManager.getTransactions()));
  }
  
  @FXML
  public void handleGenerateReport() throws IOException {
    // Code to generate a report and show it in a new window
    // Example:
    FXMLLoader loader = new FXMLLoader(getClass().getResource("report.fxml"));
    Parent root = loader.load();
    ReportController controller = loader.getController();
    controller.setTransactionManager(transactionManager);
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
  }
}

