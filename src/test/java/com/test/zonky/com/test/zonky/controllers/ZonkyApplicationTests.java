package com.test.zonky.com.test.zonky.controllers;


import com.test.zonky.controllers.MyAppController;
import com.test.zonky.domains.Loan;
import com.test.zonky.domains.Raiting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MyAppController.class)
public class ZonkyApplicationTests {

    @MockBean
    MyAppController myAppController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void marketPlaceTest() throws Exception {
        when(myAppController.getMarketplaceZonky(Raiting.AAA.getValue())).thenReturn("Average loan amount 120 for raiting AAA .");
        this.mockMvc.perform(get("/zonky/marketplace/AAA")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Average loan amount 120 for raiting AAA ."));
    }
}
