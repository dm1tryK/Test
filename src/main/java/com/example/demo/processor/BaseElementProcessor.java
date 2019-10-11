package com.example.demo.processor;

import java.io.Serializable;

public abstract class BaseElementProcessor<REQUEST extends Serializable, RESPONSE extends Serializable, DTO> implements ElementProcessor<REQUEST, RESPONSE, DTO> {
    protected abstract void processImpl(DTO dto, RESPONSE response);
    protected abstract void postProcessImpl(RESPONSE response);
    protected abstract RESPONSE createResponse(REQUEST request);
    protected abstract DTO transformImpl(REQUEST request);

    @Override
    public RESPONSE process(REQUEST request) {
        RESPONSE response = createResponse(request);
        DTO dto = transformImpl(request);
        processImpl(dto, response);
        postProcessImpl(response);
        return response;
    }

    @Override
    public DTO transform(REQUEST request) {
        return transformImpl(request);
    }
}
