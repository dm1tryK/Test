package com.example.demo.processor;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.BaseRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Deprecated
@Component
public abstract class CommonElementProcessor<T> extends BaseElementProcessor<BaseRequest<T>, BaseResponse, CommonRequestDto> {

}
