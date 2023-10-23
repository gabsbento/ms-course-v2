package com.gabrielbento.mscard.domain.service;

import com.gabrielbento.mscard.domain.entity.ClientCard;
import com.gabrielbento.mscard.domain.repository.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientCardService {
    @Autowired
    private ClientCardRepository clientCardRepository;

    public List<ClientCard> getCardsByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf);
    }

}
