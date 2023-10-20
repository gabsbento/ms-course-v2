package com.gabrielbento.mscard.domain.repository;

import com.gabrielbento.mscard.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByIncomeLessThanEqual(BigDecimal bigDecimal);
}
