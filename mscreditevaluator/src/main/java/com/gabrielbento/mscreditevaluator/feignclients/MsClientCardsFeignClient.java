package com.gabrielbento.mscreditevaluator.feignclients;

import com.gabrielbento.mscreditevaluator.domain.entity.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscard", path = "/cards")
public interface MsClientCardsFeignClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByCpf(@RequestParam("cpf") String cpf);
}
