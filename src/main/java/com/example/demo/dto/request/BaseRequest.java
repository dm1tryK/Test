package com.example.demo.dto.request;

import java.io.Serializable;

public class BaseRequest<T> implements Serializable {
    private T request;

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }
}
