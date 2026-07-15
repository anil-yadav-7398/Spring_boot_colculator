package com.example.colculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.colculator.entity.ColculatorHistory;
import com.example.colculator.service.colculatorService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private colculatorService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/history")
    public String all(Model model) {
        model.addAttribute("historyList", service.getAllhistory());
        return "history";

    }

    @GetMapping("/delete/{id}")
    public String deletedata(@PathVariable Long id) {
        service.deleteHistory(id);
        return "redirect:/history";
    }

}
