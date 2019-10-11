package com.example.demo.controller;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.dto.request.RequestHostDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.processor.ElementProcessorPath;
import com.example.demo.processor.ElementProcessorHost;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Handler {
    @Autowired
    private ElementProcessorPath processorPath;
    @Autowired
    private ElementProcessorHost processorHost;
    @Autowired
    private ProcessorService service;

    /*Get урлы для теста*/
    @GetMapping(path = "/v1/test")
    private String test() {
        BaseRequest<RequestPathDto> request = new BaseRequest<>();
        RequestPathDto dto = new RequestPathDto();
        dto.setPath("pathFromTest");
        request.setRequest(dto);
        BaseResponse response = processorPath.process(request);
        return response.getAnswer();
    }

    @GetMapping(path = "/v2/test")
    private String test2() {
        BaseRequest<RequestHostDto> request = new BaseRequest<>();
        RequestHostDto dto = new RequestHostDto();
        dto.setHost("hostFromTest");
        request.setRequest(dto);
        BaseResponse response = processorHost.process(request);
        return response.getAnswer();
    }

    /*Даже не тестил*/
    @PostMapping(path = "/v1/request")
    private String v1(@RequestBody BaseRequest<RequestPathDto> request) {
        BaseResponse response = processorPath.process(request);
        return response.getAnswer();
    }

    @PostMapping(path = "/v2/request")
    private String v2(@RequestBody BaseRequest<RequestHostDto> request) {
        BaseResponse response = processorHost.process(request);
        return response.getAnswer();
    }
}
