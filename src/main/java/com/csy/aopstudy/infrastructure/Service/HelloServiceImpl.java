package com.csy.aopstudy.infrastructure.Service;

import com.csy.aopstudy.infrastructure.Exception.CustomException;
import com.csy.aopstudy.infrastructure.aspect.CsyLogging;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    @CsyLogging(value = "Service")
    public String getHello(Long id) {
        if (id > 5) {
            throw new CustomException("AOP Throw Test");
        }
        return "Hello";
    }
}
