package com.example.demo.processor;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElementProcessorPath extends CommonElementProcessor<RequestPathDto> {
    @Autowired
    private ProcessorService service;

    @Override
    protected CommonRequestDto transformImpl(BaseRequest<RequestPathDto> request) {
        return service.createDto(request.getRequest());
    }
}
