package com.test.zonky.services;

import com.test.zonky.controllers.MarketRestController;
import com.test.zonky.data.Loan;
import com.test.zonky.data.Loans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class ZonkyServiceImpl implements ZonkyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarketRestController.class);

    @Value("${secured.service.marketplace.url}")
    private String marketPlace;

    Loans loans;


    public ZonkyServiceImpl(Loans loans) {
        this.loans = loans;
    }

    /**
     * Call Zonky marketplace.
     * @return
     */
    @Override
    public void getMarketplace() {
        final HashMap<String, String> urlParam = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Loan>> rateResponse = restTemplate.exchange(marketPlace, HttpMethod.GET, null, new ParameterizedTypeReference<List<Loan>>() {
        }, urlParam);
        List<Loan> loan = rateResponse.getBody();
        LOGGER.debug("Here is a loans from Zonky marketplace.", loan);
        loans.setLoans(loan);
    }


}
