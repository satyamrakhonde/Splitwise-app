package com.splitwise.Spliwise.app.service;

import com.splitwise.Spliwise.app.entities.Expense;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpenseService {


    public Expense addExpense(Long createdBy, String description, double amount, Map<Long, Double> splits) {
    }
}
