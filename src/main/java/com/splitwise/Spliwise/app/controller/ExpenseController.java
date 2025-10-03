package com.splitwise.Spliwise.app.controller;

import com.splitwise.Spliwise.app.entities.Expense;
import com.splitwise.Spliwise.app.request.ExpenseRequest;
import com.splitwise.Spliwise.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequest request) {
        Expense expense = expenseService.addExpense(
                request.getCreatedBy(),
                request.getDescription(),
                request.getAmount(),
                request.getSplits()
        );
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
}
