package com.example.demo.processor;

import java.io.Serializable;

public interface ElementProcessor<REQUEST extends Serializable, RESPONSE extends Serializable, DTO> {
    RESPONSE process(String request);
    DTO transform(REQUEST request);
}
