package com.example.demo.controller;

import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.dto.request.RequestHostDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.service.FacadeService;
import com.example.demo.service.v2.ElementProcessorPath;
import com.example.demo.service.v1.ElementProcessorHost;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class Handler {

    @Autowired
    FacadeService facadeService;

    @PostMapping("/v1/request")
    private Mono<BaseResponse> v2(@RequestBody BaseRequest<RequestPathDto> request) {
        return facadeService.getV2(request);
    }

    @PostMapping("/v2/request")
    private Mono<BaseResponse> v1(@RequestBody BaseRequest<RequestHostDto> request) {
        return facadeService.getV1(request);
    }
}
