package com.gabrielbento.mscard.controller;

import com.gabrielbento.mscard.domain.dto.CardForClientResponse;
import com.gabrielbento.mscard.domain.dto.CardSaveRequest;
import com.gabrielbento.mscard.domain.entity.Card;
import com.gabrielbento.mscard.domain.entity.ClientCard;
import com.gabrielbento.mscard.domain.service.CardService;
import com.gabrielbento.mscard.domain.service.ClientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

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

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardForClientResponse>> getCardsByCpf(@RequestParam("cpf") String cpf) {
        List<ClientCard> cards = clientCardService.getCardsByCpf(cpf);
        List<CardForClientResponse> resultList = cards.stream().map(CardForClientResponse::from).collect(Collectors.toList());
        return ResponseEntity.ok().body(resultList);
    }


}
