package com.gabrielbento.mscreditevaluator.controller;

import com.gabrielbento.mscreditevaluator.domain.entity.ClientSituation;
import com.gabrielbento.mscreditevaluator.domain.service.CreditEvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation")
@RequiredArgsConstructor
public class CreditEvaluatorController {

    private final CreditEvaluatorService creditEvaluatorService;

    @GetMapping
    public String status() {
        return "Hello World";
    }

    @GetMapping(value = "/customer-situation", params = {"cpf"})
    public ResponseEntity<ClientSituation> getClientSituation(@RequestParam("cpf") String cpf) {
        ClientSituation clientSituation = creditEvaluatorService.getClientSituation(cpf);
        return ResponseEntity.ok(clientSituation);
    }
}
