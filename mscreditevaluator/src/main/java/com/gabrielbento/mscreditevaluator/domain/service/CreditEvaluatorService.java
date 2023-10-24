package com.gabrielbento.mscreditevaluator.domain.service;

import com.gabrielbento.mscreditevaluator.domain.entity.ClientDate;
import com.gabrielbento.mscreditevaluator.domain.entity.ClientSituation;
import com.gabrielbento.mscreditevaluator.feignclients.MsClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final MsClientFeignClient msClientFeignClient;
    public ClientSituation getClientSituation(String cpf) {
        ResponseEntity<ClientDate> clientDateResponse = msClientFeignClient.findClientByCPF(cpf);

        return ClientSituation.builder().clientDate(clientDateResponse.getBody()).build();
    }}
