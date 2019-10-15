package com.example.demo.adapter;

import org.springframework.stereotype.Component;

@Component
public class FirstLevelResponseAdapter {

    public String adapt(String response) {
        try {
            return response.split("<head>")[1].split("</head>")[0];
        } catch (IndexOutOfBoundsException ex) {
            return "";
        }
    }
}
