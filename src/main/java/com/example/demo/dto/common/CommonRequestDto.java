package com.example.demo.dto.common;

public class CommonRequestDto {
    private String path;
    private String host;

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
