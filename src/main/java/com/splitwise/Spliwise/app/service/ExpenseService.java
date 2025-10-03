package com.splitwise.Spliwise.app.service;

import com.splitwise.Spliwise.app.entities.Expense;
import com.splitwise.Spliwise.app.entities.ExpenseSplit;
import com.splitwise.Spliwise.app.entities.User;
import com.splitwise.Spliwise.app.repository.ExpenseRepository;
import com.splitwise.Spliwise.app.repository.ExpenseSplitRepository;
import com.splitwise.Spliwise.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseSplitRepository splitRepository;

    public Expense addExpense(Long createdById, String description,
                              double amount, Map<Long, Double> splits) {
        User creator = userRepository.findById(createdById)
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        Expense expense = new Expense();
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setCreatedBy(creator);
        Expense saved = expenseRepository.save(expense);

        for(Map.Entry<Long, Double> entry : splits.entrySet()) {
            User user = userRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            ExpenseSplit split = new ExpenseSplit();
            split.setExpense(saved);
            split.setUser(user);
            split.setAmount(entry.getValue());
            splitRepository.save(split);
        }
        return saved;
    }
}
