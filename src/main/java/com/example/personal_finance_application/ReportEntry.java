//---------------------------------------------------------------------------
//
// ReportEntry
// Entry format for the table in any view
//
// Author: Girish Madnani
// Date: 05/02/23
// Class: MET CS622
// Issues: None known
//
// Description:
// This class is used from generics and the entries in the csv are stored here
// for manipulation
//
// Assumptions:
// none
//

package com.example.personal_finance_application;

import java.time.LocalDate;
public class ReportEntry {
  private String type;
  private double amount;
  private String category;
  private LocalDate date;
  private String notes;
  
  public ReportEntry(String type, double amount, String category, LocalDate date, String notes) {
    this.type = type;
    this.amount = amount;
    this.category = category;
    this.date = date;
    this.notes = notes;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public String getCategory() {
    return category;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public String getNotes() {
    return notes;
  }
  
  public String getType() {
    return type;
  }
  
}
