//---------------------------------------------------------------------------
//
// Welcome
// Starting point of the application
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class displays the login and register button
//
// Assumptions:
// none
//

package com.example.personal_finance_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
public class Welcome {
  @FXML
  private Button loginButton;
  
  @FXML
  private Button registerButton;
  
  ///////////////////////////////////////////////////////////////////
/// onLogin (navigates to login page)                             ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onLogin() throws IOException {
    // navigate to login page
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current welcome window
    Stage currentStage = (Stage) loginButton.getScene().getWindow();
    currentStage.close();
  }
  
  ///////////////////////////////////////////////////////////////////
/// onRegister (navigates to register page)                       ///
///////////////////////////////////////////////////////////////////
  @FXML
  private void onRegister() throws IOException {
    // navigate to register page
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 600, 800));
    stage.show();
    // close the current welcome window
    Stage currentStage = (Stage) registerButton.getScene().getWindow();
    currentStage.close();
  }
}
