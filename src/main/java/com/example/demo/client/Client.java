package com.example.demo.client;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Client {

    WebClient webClient = WebClient.builder()
            .build();

    public Mono<String> getRequest(CommonRequestDto dto) {
        return webClient.get()
                .uri(dto.getHost() + dto.getPath())
                .exchange()
                .flatMap( clientResponse -> clientResponse.bodyToMono(String.class));
    }
}
