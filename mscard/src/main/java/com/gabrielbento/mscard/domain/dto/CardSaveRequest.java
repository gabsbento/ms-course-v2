package com.gabrielbento.mscard.domain.dto;

import com.gabrielbento.mscard.domain.entity.Card;
import com.gabrielbento.mscard.domain.entity.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {
    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal limitBasic;

    public Card toCard() {
        return new Card(name, brand, income, limitBasic);
    }
}
