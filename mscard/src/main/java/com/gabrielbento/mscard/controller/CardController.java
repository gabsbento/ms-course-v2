package com.gabrielbento.mscard.controller;

import com.gabrielbento.mscard.domain.dto.CardSaveRequest;
import com.gabrielbento.mscard.domain.entity.Card;
import com.gabrielbento.mscard.domain.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity createCard(@RequestBody CardSaveRequest request) {
        cardService.save(request.toCard());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsWithIncomeLessThanOrEqual(@RequestParam("income") Long income) {
        List<Card> cards = cardService.getCardsWithIncomeLessThanOrEqual(income);
        return ResponseEntity.ok().body(cards);
    }


}
