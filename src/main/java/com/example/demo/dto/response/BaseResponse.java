package com.example.demo.dto.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
