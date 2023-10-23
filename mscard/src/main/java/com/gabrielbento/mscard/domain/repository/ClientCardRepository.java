package com.gabrielbento.mscard.domain.repository;

import com.gabrielbento.mscard.domain.entity.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {


    List<ClientCard> findByCpf(String cpf);
}
