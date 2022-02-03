package net.illay.cryptoCurrency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.illay.cryptoCurrency.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
public class UpdatePriceServiceImpl implements UpdatePriceService{

    private String url = "https://api.coinlore.net/api/ticker/?id=";

    @Autowired
    private CoinService coinService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Lazy
    private LoggingService loggingService;

    @Scheduled(cron = "0 * * * * *")
    public void updatePrice(){
        log.info("------------- Check stated -------------");
        coinService.getAll().stream().forEach(coin -> {
            try {
                putNewPriceInDataBase(coin);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        log.info("------------- Check ended -------------");
    }

    public String createRequest(Coin coin){
        return url+coin.getId().toString();
    }

    public BigDecimal getCurrentPrice(Coin coin) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> entity = restTemplate.getForEntity(createRequest(coin), String.class);
        JsonNode jsonNode = mapper.readTree(entity.getBody());
        BigDecimal price = BigDecimal.valueOf(jsonNode.get(0).get("price_usd").asDouble());

        log.info("Name of coin: "+ coin.getSymbol() +
                 " old price is = " + coin.getPrice() +
                 " and new price is = " + price.toString());

        log.info("Percentage difference of coin " + coin.getSymbol() +" between new and old price: "
                + loggingService.checkingPercentOfChange(coin.getPrice(), price).toString() + "%");

        if(loggingService.checkingPercentOfChange(coin.getPrice(), price).compareTo(BigDecimal.valueOf(1)) == 1){
            loggingService.logChangeOfPrice(coin, price);
        }
        return price;
    }

    public Coin putNewPriceInDataBase(Coin coin) throws JsonProcessingException {
        Coin updatedCoin = Coin.builder().id(coin.getId()).symbol(coin.getSymbol()).price(getCurrentPrice(coin)).build();
        return coinService.update(updatedCoin);
    }
}
