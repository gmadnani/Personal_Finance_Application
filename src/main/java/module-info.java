module com.example.personal_finance_application {
  requires javafx.controls;
  requires javafx.fxml;
  
  
  opens com.example.personal_finance_application to javafx.fxml;
  exports com.example.personal_finance_application;
}
