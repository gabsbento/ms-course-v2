package com.gabrielbento.mscard.domain.dto;

import com.gabrielbento.mscard.domain.entity.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardForClientResponse {

    private String name;
    private String brand;
    private BigDecimal limitValue;

    public static CardForClientResponse from(ClientCard clientCard) {
        return new CardForClientResponse(clientCard.getCard().getName(), clientCard.getCard().getBrand().toString(), clientCard.getLimitValue());
    }

}
