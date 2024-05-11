package com.avila.smartfit.controller;
import com.avila.smartfit.exception.advice.InvalidEndpointException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {
    @RequestMapping("**")
    void handleInvalidEndpoint(){
        throw new InvalidEndpointException();
    }
}