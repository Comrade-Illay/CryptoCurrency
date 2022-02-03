package net.illay.cryptoCurrency.service;

import net.illay.cryptoCurrency.entity.Coin;
import net.illay.cryptoCurrency.entity.User;

import java.math.BigDecimal;

public interface LoggingService {

    void logChangeOfPrice(Coin coin, BigDecimal currentPrice);
    BigDecimal checkingPercentOfChange(BigDecimal previousPrice, BigDecimal currentPrice);
}
