package com.example.colculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.colculator.service.colculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ColculateController {
    @Autowired
    private colculatorService colculatorService;

    @PostMapping("/calculate")
    public String colculator(@RequestParam double num1, double num2, String opration, Model model) {
        try {
            double result = colculatorService.colculate(num1, num2, opration);
            colculatorService.saveHistory(num1, num2, opration, result);

            model.addAttribute("result", result);

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }

        return "index";
    }

}
