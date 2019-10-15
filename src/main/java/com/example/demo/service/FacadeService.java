package com.example.demo.service;

import com.example.demo.adapter.FirstLevelResponseAdapter;
import com.example.demo.client.Client;
import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestHostDto;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.service.v1.ElementProcessorHost;
import com.example.demo.service.v2.ElementProcessorPath;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FacadeService {

    ElementProcessorHost processorHost;
    ElementProcessorPath processorPath;

    FirstLevelResponseAdapter firstLevelResponseAdapter;

    Client client;

    public Mono<BaseResponse> getV1(BaseRequest<RequestHostDto> request) {
        return getBaseRequest(
                processorHost.transform(request)
        ).map(processorHost::process);
    }

    public Mono<BaseResponse> getV2(BaseRequest<RequestPathDto> request) {
        return getBaseRequest(
                processorPath.transform(request)
        ).map(processorPath::process);
    }

    public Mono<String> getBaseRequest(CommonRequestDto commonRequestDto) {
        return client.getRequest(commonRequestDto)
                .map(firstLevelResponseAdapter::adapt);
    }
}
