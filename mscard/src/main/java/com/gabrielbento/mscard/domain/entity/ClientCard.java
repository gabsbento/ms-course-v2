package com.gabrielbento.mscard.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "client_card")
@NoArgsConstructor
@Data
public class ClientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private BigDecimal limitValue;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;
}
