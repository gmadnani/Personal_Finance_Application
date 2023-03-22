package com.example.personal_finance_application;

import java.time.LocalDate;
public class Transaction {
  private String category;
  private double amount;
  
  
  public Transaction(String category, double amount, LocalDate date) {
    this.category = category;
    this.amount = amount;
  }
  
  public String getCategory() {
    return category;
  }
  
  public double getAmount() {
    return amount;
  }
  
  
}
