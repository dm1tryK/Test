package com.example.demo.processor;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommonElementProcessor<T> extends BaseElementProcessor<BaseRequest<T>, BaseResponse, CommonRequestDto> {
    @Autowired
    ProcessorService service;

    @Override
    protected BaseResponse createResponse(BaseRequest<T> tBaseRequest) {
        return new BaseResponse();
    }

    @Override
    protected CommonRequestDto transformImpl(BaseRequest<T> request) {
        return null;
    }

    @Override
    protected void processImpl(CommonRequestDto dto, BaseResponse response) {
        response.setAnswer(true ? service.doRequest(dto) : service.ERROR);
    }

    @Override
    protected void postProcessImpl(BaseResponse baseResponse) {
    }
}
