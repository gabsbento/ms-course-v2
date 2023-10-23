package com.gabrielbento.mscreditevaluator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation")
public class CreditEvaluatorController {

    @GetMapping
    public String status() {
        return "Hello World";
    }
}
