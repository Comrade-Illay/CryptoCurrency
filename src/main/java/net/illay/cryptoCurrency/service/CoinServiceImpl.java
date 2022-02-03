package net.illay.cryptoCurrency.service;

import net.illay.cryptoCurrency.entity.Coin;
import net.illay.cryptoCurrency.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService{

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getAll(){
        return coinRepository.findAll();
    };

    public BigDecimal getPriceBySymbol(String symbol) {
        return coinRepository.findCoinBySymbol(symbol).getPrice();
    }

    public Coin update(Coin coin){
        return coinRepository.save(coin);
    };

    public Coin getCoinBySymbol(String symbol){
        return coinRepository.findCoinBySymbol(symbol);
    };
}
