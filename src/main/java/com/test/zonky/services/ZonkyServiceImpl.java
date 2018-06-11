package com.test.zonky.services;

import com.test.zonky.domains.Loan;
import com.test.zonky.domains.Raiting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonkyServiceImpl implements ZonkyService {

    @Value("${secured.service.marketplace.url}")
    private String marketPlace;

    public ZonkyServiceImpl() {
    }

    /**
     * Method call Zomky marketplace.
     * @param rating
     * @return
     */
    @Override
    public List<Loan> getMarketplace(Raiting rating) {
        final HashMap<String, String> urlParam = new HashMap<>();
        urlParam.put("rating", rating.name());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Loan>> rateResponse = restTemplate.exchange(marketPlace, HttpMethod.GET, null, new ParameterizedTypeReference<List<Loan>>() {
        }, urlParam);
        List<Loan> loans = rateResponse.getBody();
        loans.forEach(lo -> System.out.println("Readed loan object --" + lo));
        System.out.println("list of loans >>>>" + loans);

        return loans;
    }

    /**
     * Method returns average loan amount.
     * @param loans
     * @param raiting
     * @return
     */
    @Override
    public Long getAverageLoanAmount(List<Loan> loans, Raiting raiting) {
        long amountSum = 0;
        List<Integer> filteredAmounts = loans.stream().filter(lo -> lo.getRating().equals(raiting.name())).map(lo -> lo.getAmount()).collect(Collectors.toList());
        for (Integer am : filteredAmounts) {
            amountSum = amountSum + am;
        }
        if (filteredAmounts.size() > 0) {
            return amountSum / filteredAmounts.size();
        } else {
            return 0L;
        }
    }


}
