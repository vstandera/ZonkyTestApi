package com.test.zonky.controllers;

import com.test.zonky.data.Loan;
import com.test.zonky.data.Loans;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MarketControllerTest {

    MarketController marketController;
    @Mock
    Loans loans;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        marketController = new MarketController(loans);
        mockMvc = MockMvcBuilders.standaloneSetup(marketController).build();
    }


    @Test
    public void getAllFines() throws Exception {
        List<Loan> loansL = new ArrayList<>();
        final Loan loan = new Loan();
        loan.setAmount(20000);
        loan.setId(1222333L);
        loan.setStory("Zonky story1");
        loan.setUrl("https://app.zonky.cz/loan/408969");
        loansL.add(loan);
        final Loan loan2 = new Loan();
        loan2.setAmount(232131);
        loan2.setId(6546564L);
        loan2.setStory("Zonky story2");
        loan2.setUrl("https://app.zonky.cz/loan/408969");
        loansL.add(loan2);

        when(loans.getLoans()).thenReturn(loansL);

        mockMvc.perform(get("/marketplace"))
                .andExpect(status().isOk())
                .andExpect(view().name("market/zonkyMarket"))
                .andExpect(model().attribute("market", hasSize(2)));
        verify(loans, times(1)).getLoans();
    }
}