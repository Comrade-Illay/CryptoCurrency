package net.illay.cryptoCurrency.repository;

import net.illay.cryptoCurrency.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository <Coin, Long>{
    Coin findCoinBySymbol(String symbol);
}
