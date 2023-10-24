package com.gabrielbento.mscreditevaluator.feignclients;

import com.gabrielbento.mscreditevaluator.domain.entity.ClientDate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "msclients", path = "/clients")
public interface MsClientFeignClient {

    @GetMapping(params = {"cpf"})
    ResponseEntity<ClientDate> findClientByCPF(@RequestParam String cpf);
}
