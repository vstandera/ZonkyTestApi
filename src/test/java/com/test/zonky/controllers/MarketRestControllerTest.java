package com.test.zonky.controllers;

import com.test.zonky.data.Loan;
import com.test.zonky.data.Loans;
import com.test.zonky.services.ZonkyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class  MarketRestControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    MarketRestController marketRestController;
    MockMvc mockMvc;

    @Mock
    ZonkyService zonkyService;
    @Mock
    Loans loans;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        marketRestController = new MarketRestController(zonkyService, loans);
        mockMvc = MockMvcBuilders.standaloneSetup(marketRestController).build();
    }

    @Test
    public void marketPlaceTest() throws Exception {
        List<Loan> loansL = new ArrayList<>();
        final Loan loan = new Loan();
        loan.setAmount(20000);
        loan.setId(1222333L);
        loan.setStory("Zonky story1");
        loan.setUrl("https://app.zonky.cz/loan/408969");
        loan.setDeadline(new Date());
        loansL.add(loan);
        final Loan loan2 = new Loan();
        loan2.setAmount(232131);
        loan2.setId(6546564L);
        loan2.setStory("Zonky story2");
        loan2.setUrl("https://app.zonky.cz/loan/408969");
        loan2.setDeadline(new Date());
        loansL.add(loan2);
        when(loans.getLoans()).thenReturn(loansL);

        this.mockMvc.perform(get("/zonky/marketplace")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].story", is("Zonky story1")))
                .andExpect(jsonPath("$[0].url", is("https://app.zonky.cz/loan/408969")))
                .andExpect(jsonPath("$[0].amount", is(20000)))
                .andExpect(jsonPath("$[0].id", is(1222333)))
                .andExpect(jsonPath("$[1].story", is("Zonky story2")))
                .andExpect(jsonPath("$[1].url", is("https://app.zonky.cz/loan/408969")))
                .andExpect(jsonPath("$[1].amount", is(232131)))
                .andExpect(jsonPath("$[1].id", is(6546564)));
    }
}