package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
public class AddTransactionController {
  @FXML
  private TextField categoryTextField;
  
  @FXML
  private TextField amountTextField;
  
  @FXML
  private DatePicker dateDatePicker;
  
  private TransactionManager transactionManager;
  
  public void setTransactionManager(TransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }
  
  @FXML
  public void handleAdd() {
    String category = categoryTextField.getText();
    double amount = Double.parseDouble(amountTextField.getText());
    LocalDate date = dateDatePicker.getValue();
    Transaction transaction = new Transaction(category, amount, date);
    transactionManager.addTransaction(transaction);
    categoryTextField.clear();
    amountTextField.clear();
    dateDatePicker.setValue(null);
    ((Stage) categoryTextField.getScene().getWindow()).close();
  }
}
