package com.test.zonky.controllers;

import com.test.zonky.data.Loan;
import com.test.zonky.data.Loans;
import com.test.zonky.services.ZonkyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MarketRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketRestController.class);
    ZonkyService zonkyService;
    Loans loans;

    public MarketRestController(ZonkyService zonkyService, Loans loans) {
        this.zonkyService = zonkyService;
        this.loans = loans;
    }

    /**
     * Return MarketPalece json object
     * @return
     */
    @RequestMapping("/zonky/marketplace")
    public  ResponseEntity<List<Loan>> getMarketplaceZonky(){
                LOGGER.info("String from MarketPlace loaded.");
                zonkyService.getMarketplace();

        return new ResponseEntity<>(loans.getLoans(), HttpStatus.OK);
    }

}
