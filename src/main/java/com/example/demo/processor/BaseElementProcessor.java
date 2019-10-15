package com.example.demo.processor;

import java.io.Serializable;

public abstract class BaseElementProcessor<REQUEST extends Serializable, RESPONSE extends Serializable, DTO> implements ElementProcessor<REQUEST, RESPONSE, DTO> {

    protected abstract RESPONSE processImpl(String clientResponse);

    protected abstract DTO transformImpl(REQUEST request);

    /**
     * @param clientResponse - client answer
     * @return Full Response
     */
    @Override
    public RESPONSE process(String clientResponse) {
        //any common logic here
        return processImpl(clientResponse);
    }

    /**
     * @param request - input request
     * @return DTO - for postProcessing
     */
    @Override
    public DTO transform(REQUEST request) {
        //any common logic here
        return transformImpl(request);
    }
}
