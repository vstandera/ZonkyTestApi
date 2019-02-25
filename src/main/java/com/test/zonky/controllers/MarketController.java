package com.test.zonky.controllers;


import com.test.zonky.data.Loans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketController {

    Loans loans;

    public MarketController(Loans loans) {
        this.loans = loans;
    }

    /**
     * Show Loans page
     * @param model
     * @return
     */
    @GetMapping("/marketplace")
    public String getAllFines(Model model){
        model.addAttribute("market",loans.getLoans());

        return "market/zonkyMarket";
    }
}
