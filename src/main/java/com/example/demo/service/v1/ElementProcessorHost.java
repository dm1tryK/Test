package com.example.demo.service.v1;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestHostDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.processor.BaseElementProcessor;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElementProcessorHost extends BaseElementProcessor<BaseRequest<RequestHostDto> , BaseResponse, CommonRequestDto> {

    @Value("${request.path}")
    private String missedBody;

    @Override
    protected BaseResponse processImpl(String clientAnswer) {
        return new BaseResponse(){{
            setAnswer(clientAnswer);
        }};
    }

    @Override
    protected CommonRequestDto transformImpl(BaseRequest<RequestHostDto> requestHostDtoBaseRequest) {
        return new CommonRequestDto() {{
            setPath(missedBody);
            setHost(requestHostDtoBaseRequest.getRequest().getHost());
        }};
    }

}
