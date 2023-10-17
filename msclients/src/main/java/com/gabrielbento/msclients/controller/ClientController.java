package com.gabrielbento.msclients.controller;

import com.gabrielbento.msclients.domain.dto.ClientSaveRequest;
import com.gabrielbento.msclients.domain.entity.Client;
import com.gabrielbento.msclients.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest clientRequest){
        var client = clientRequest.toModel();
        clientService.save(client);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity findClientByCPF(@RequestParam String cpf){
        Optional<Client> client = clientService.getByCPF(cpf);
        if(client.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(client);
    }
}
