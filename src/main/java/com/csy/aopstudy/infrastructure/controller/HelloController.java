package com.csy.aopstudy.infrastructure.controller;

import com.csy.aopstudy.infrastructure.Exception.CustomException;
import com.csy.aopstudy.infrastructure.Service.HelloService;
import com.csy.aopstudy.infrastructure.aspect.CsyLogging;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/{id}")
    public String helloWorld(@PathVariable("id") Long id){

        return helloService.getHello(id);
    }
}
