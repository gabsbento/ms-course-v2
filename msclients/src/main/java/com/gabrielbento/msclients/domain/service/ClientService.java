package com.gabrielbento.msclients.domain.service;

import com.gabrielbento.msclients.domain.entity.Client;
import com.gabrielbento.msclients.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }
}
