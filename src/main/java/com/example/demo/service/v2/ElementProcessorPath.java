package com.example.demo.service.v2;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.processor.CommonElementProcessor;
import com.example.demo.service.v2.adapter.SecondLevelResponseAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElementProcessorPath extends CommonElementProcessor<RequestPathDto> {

    @Value("${request.host}")
    private String missedBody;

    private SecondLevelResponseAdapter secondLevelResponseAdapter;

    @Override
    protected BaseResponse processImpl(String clientAnswer) {
        return new BaseResponse() {{
            setAnswer(secondLevelResponseAdapter.countLess(clientAnswer));
        }};
    }

    @Override
    protected CommonRequestDto transformImpl(BaseRequest<RequestPathDto> requestPathDtoBaseRequest) {
        return new CommonRequestDto() {{
            setHost(missedBody);
            setPath(requestPathDtoBaseRequest.getRequest().getPath());
        }};
    }
}
