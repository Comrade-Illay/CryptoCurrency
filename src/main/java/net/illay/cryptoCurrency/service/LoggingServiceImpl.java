package net.illay.cryptoCurrency.service;

import lombok.extern.slf4j.Slf4j;
import net.illay.cryptoCurrency.entity.Coin;
import net.illay.cryptoCurrency.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Slf4j
@Service
public class LoggingServiceImpl implements LoggingService{

    @Autowired
    private UserService userService;

    public void logChangeOfPrice(Coin coin, BigDecimal currentPrice){
        List<User> users = userService.getUsersByCode(coin.getSymbol());
        users.stream().forEach(user -> log.warn("Price change for: " + user.getCode() +
                ", user: " + user.getName() +
                ". Percentage change: " + checkingPercentOfChange(user.getPrice(), currentPrice)));

    }

    public BigDecimal checkingPercentOfChange(BigDecimal previousPrice, BigDecimal currentPrice){
        if(previousPrice.compareTo(currentPrice) == 0) {
            return BigDecimal.valueOf(0);
        } else {
            return (((previousPrice.subtract(currentPrice))
                    .abs()).divide(previousPrice, 10 , RoundingMode.HALF_UP))
                    .multiply(BigDecimal.valueOf(100));
        }
    }
}
