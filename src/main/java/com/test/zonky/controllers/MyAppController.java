package com.test.zonky.controllers;

import com.test.zonky.domains.Loan;
import com.test.zonky.domains.Raiting;
import com.test.zonky.services.ZonkyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyAppController {

    @Autowired
    ZonkyService zonkyService;

    @RequestMapping("/zonky/marketplace/{rating}")
    public @ResponseBody String getMarketplaceZonky(@PathVariable String rating){
        Raiting ratingEnum  = this.validateRating(rating);
        final List<Loan> marketplace = zonkyService.getMarketplace(ratingEnum);
        return "Average loan amount " + zonkyService.getAverageLoanAmount(marketplace, ratingEnum) +" for raiting "+ ratingEnum.getValue()+".";

    }

    private Raiting validateRating(String rating){

        if (Raiting.findValue(rating)==null){
            throw new RuntimeException("Bad raiting param >"+ rating);
        }else{
            return Raiting.findValue(rating);
        }
    }


}
