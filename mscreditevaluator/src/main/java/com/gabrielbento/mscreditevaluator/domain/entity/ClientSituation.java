package com.gabrielbento.mscreditevaluator.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSituation {
    private ClientDate clientDate;
    private List<ClientCard> clientCards;
}
