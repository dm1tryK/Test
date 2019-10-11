package com.example.demo.processor;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestHostDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElementProcessorHost extends CommonElementProcessor<RequestHostDto> {
    @Autowired
    private ProcessorService service;

    @Override
    protected void postProcessImpl(BaseResponse response) {
        if (ProcessorService.ERROR.equals(response.getAnswer())) return;
        Integer count = response.getAnswer().split("body>", -1).length - 1;
        response.setAnswer(String.valueOf(count));
    }

    @Override
    protected CommonRequestDto transformImpl(BaseRequest<RequestHostDto> request) {
        return service.createDto(request.getRequest());
    }
}
