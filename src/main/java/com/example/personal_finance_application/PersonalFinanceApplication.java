//---------------------------------------------------------------------------
//
// Personal Finance Application
// Allows a person keep a track of their day to day income and expenses
//
// Author: Girish Madnani
// Date: 05/02/18
// Class: MET CS622
// Issues: None known
//
// Description:
// This program is a finance management application where a user can create
// an account and login. A user can add, delete and view their income and
// expense. It shows the total income and expense and calculates the savings.
// It also can generate a report of your income and expenses.
//
// Assumptions:
// The app starts from the welcome screen
//

package com.example.personal_finance_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class PersonalFinanceApplication extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    stage.setTitle("BMI Calculator");
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
  }
  
  
  public static void main(String[] args) {
    launch();
  }
}

