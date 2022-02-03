package net.illay.cryptoCurrency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.illay.cryptoCurrency.entity.Coin;

import java.math.BigDecimal;

public interface UpdatePriceService {

    void updatePrice();
    BigDecimal getCurrentPrice(Coin coin) throws JsonProcessingException;
}
