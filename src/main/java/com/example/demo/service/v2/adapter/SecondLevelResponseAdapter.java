package com.example.demo.service.v2.adapter;

import org.springframework.stereotype.Component;

@Component
public class SecondLevelResponseAdapter {

    public String countLess(String clientResponse) {
        return String.valueOf(
                clientResponse.split("<").length - 1
        );
    }
}
