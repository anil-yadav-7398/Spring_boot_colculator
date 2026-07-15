package com.example.colculator.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colculator.entity.ColculatorHistory;
import com.example.colculator.repository.ColculatorHistoryRepository;

@Service
public class colculatorService {
    @Autowired
    private ColculatorHistoryRepository repository;

    public void saveHistory(double num1, double num2, String opration, double result) {
        ColculatorHistory history = new ColculatorHistory();
        history.setNum1(num1);
        history.setNum2(num2);
        history.setOpration(opration);
        history.setResult(result);
        history.setCreateAt(LocalDateTime.now());
        repository.save(history);
    }

    public double colculate(double num1, double num2, String opration) {
        return switch (opration) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divided by zero");
                }
                yield num1 / num2;
            }
            case "%" -> num1 % num2;
            default -> throw new IllegalArgumentException("Invalid opration");
        };
    }

    public List<ColculatorHistory> getAllhistory() {
        return repository.findAll();
    }

    public void deleteHistory(Long id) {
        repository.deleteById(id);
    }
}
