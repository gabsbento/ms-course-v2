package com.gabrielbento.mscreditevaluator.domain.service;

import com.gabrielbento.mscreditevaluator.domain.entity.ClientCard;
import com.gabrielbento.mscreditevaluator.domain.entity.ClientDate;
import com.gabrielbento.mscreditevaluator.domain.entity.ClientSituation;
import com.gabrielbento.mscreditevaluator.feignclients.MsClientCardsFeignClient;
import com.gabrielbento.mscreditevaluator.feignclients.MsClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final MsClientFeignClient msClientFeignClient;
    private final MsClientCardsFeignClient msClientCardsFeignClient;
    public ClientSituation getClientSituation(String cpf) {
        ResponseEntity<ClientDate> clientDateResponse = msClientFeignClient.findClientByCPF(cpf);
        ResponseEntity<List<ClientCard>> cardsByCpf = msClientCardsFeignClient.getCardsByCpf(cpf);

        return ClientSituation.builder().clientDate(clientDateResponse.getBody()).clientCards(cardsByCpf.getBody()).build();
    }

}
