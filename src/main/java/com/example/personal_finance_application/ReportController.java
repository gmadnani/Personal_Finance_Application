package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
public class ReportController {
  @FXML
  private Button goBackButton;
  
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
