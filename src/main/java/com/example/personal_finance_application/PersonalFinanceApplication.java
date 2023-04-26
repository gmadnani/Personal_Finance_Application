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

