package com.gabrielbento.mscard.domain.service;

import com.gabrielbento.mscard.domain.entity.Card;
import com.gabrielbento.mscard.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getCardsWithIncomeLessThanOrEqual(Long income) {
        return cardRepository.findByIncomeLessThanEqual(BigDecimal.valueOf(income));
    }

}
