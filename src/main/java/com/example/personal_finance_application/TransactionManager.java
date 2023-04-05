package com.example.personal_finance_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class TransactionManager {
  private List<Transaction> transactions;
  
  public TransactionManager() {
    transactions = new ArrayList<>();
  }
  
  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }
  
  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  public double getTotalSpending() {
    return transactions.stream()
        .mapToDouble(Transaction::getAmount)
        .sum();
  }
  
  public Map<String, Double> getCategorySpending() {
    return transactions.stream()
        .collect(Collectors.groupingBy(Transaction::getCategory,
            Collectors.summingDouble(Transaction::getAmount)));
  }
}
