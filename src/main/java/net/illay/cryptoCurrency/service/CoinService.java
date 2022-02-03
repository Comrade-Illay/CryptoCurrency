package net.illay.cryptoCurrency.service;

import net.illay.cryptoCurrency.entity.Coin;

import java.math.BigDecimal;
import java.util.List;

public interface CoinService {

    List<Coin> getAll();
    BigDecimal getPriceBySymbol(String symbol);
    Coin update(Coin coin);
    Coin getCoinBySymbol(String symbol);
}
