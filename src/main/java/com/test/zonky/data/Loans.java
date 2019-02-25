package com.test.zonky.data;

import com.test.zonky.controllers.MarketRestController;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Loans from Market Place
 */
@Component
@Getter
public class Loans {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketRestController.class);
    /**
     * Loans from Zonky Marketplace
     */
    private List<Loan> loans;

    public void setLoans(List<Loan> loans) {
        LOGGER.info("The loans is change.");
        this.loans = loans;
    }
}
