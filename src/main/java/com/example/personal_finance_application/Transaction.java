package com.example.personal_finance_application;

import java.time.LocalDate;
public class Transaction {
  private String category;
  private double amount;
  private LocalDate date;
  
  public Transaction(String category, double amount, LocalDate date) {
    this.category = category;
    this.amount = amount;
    this.date = date;
  }
  
  public String getCategory() {
    return category;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public LocalDate getDate() {
    return date;
  }
}

