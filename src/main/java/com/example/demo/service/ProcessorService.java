package com.example.demo.service;

import com.example.demo.dto.common.CommonRequestDto;
import com.example.demo.dto.request.RequestPathDto;
import com.example.demo.dto.request.RequestHostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Deprecated
@Service
@PropertySource("application.properties")
public class ProcessorService {
    @Autowired
    private Environment environment;
    private static final String HOST = "request.host";
    private static final String PATH = "request.path";
    public static final String ERROR = "ne200";

    private String getProperty(String propName) {
        return environment.getProperty(propName);
    }

    public CommonRequestDto createDto(RequestPathDto v1DTO) {
        CommonRequestDto dto = new CommonRequestDto();
        dto.setPath(v1DTO.getPath());
        dto.setHost(getProperty(HOST));
        return dto;
    }

    public CommonRequestDto createDto(RequestHostDto v2DTO) {
        CommonRequestDto dto = new CommonRequestDto();
        dto.setHost(v2DTO.getHost());
        dto.setPath(getProperty(PATH));
        return dto;
    }

    public String doRequest(CommonRequestDto dto) {
        System.out.println(String.format("REQUEST TO %s%s", dto.getHost(),dto.getPath()));
        return "qwew <html>\n" +
                " <head>\n" +
                "   <!-- Этот раздел предназначен для заголовка страницы и технической информации. -->\n" +
                " </head>\n" +
                "\n" +
                " <body>\n" +
                "   <!-- А здесь надо размещать все, что хочется увидеть на странице. -->\n" +
                " </body>\n" +
                "</html>";
    }
}
