package net.illay.cryptoCurrency.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "crypto_currency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coin {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "price")
    private BigDecimal price;
}
