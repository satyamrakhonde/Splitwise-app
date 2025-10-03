package com.splitwise.Spliwise.app.request;

import lombok.Data;

import java.util.Map;

@Data
public class ExpenseRequest {
    private Long createdBy;
    private String description;
    private double amount;
    private Map<Long, Double> splits; // userId -> amount
}
