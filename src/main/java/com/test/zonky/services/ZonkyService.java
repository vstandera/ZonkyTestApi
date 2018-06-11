package com.test.zonky.services;

import com.test.zonky.domains.Loan;
import com.test.zonky.domains.Raiting;

import java.util.List;

public interface ZonkyService {

    public List<Loan> getMarketplace(Raiting rating);

    public Long getAverageLoanAmount(List<Loan> loans, Raiting raiting);
}
