
package com.example.expense_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final List<Expense> expenses = new ArrayList<>();
    private long nextId = 1;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setId(nextId++);
        expenses.add(expense);
        return expense;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenses;
    }
}
