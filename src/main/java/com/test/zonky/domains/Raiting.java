package com.test.zonky.domains;

import java.util.Arrays;
import java.util.List;

public enum Raiting {
    AAAA("A**"),
    AAA("A*"),
    AA("A+"),
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private String value;

    Raiting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Raiting findValue(String value){
        List<Raiting> values = Arrays.asList(Raiting.values());
        for(Raiting val:values){
            if(val.getValue().equals(value))
                return val;
        }
        return null;
    }
}
