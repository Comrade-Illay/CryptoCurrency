package net.illay.cryptoCurrency.controller;

import net.illay.cryptoCurrency.entity.Coin;
import net.illay.cryptoCurrency.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cryptoCurrency/coin")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(value = "{symbol}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> getCoinPriceBySymbol(@PathVariable("symbol") String symbol){
        return new ResponseEntity<>(coinService.getPriceBySymbol(symbol), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Coin>> getListOfCoins(){
        return new ResponseEntity<>(coinService.getAll(), HttpStatus.OK);
    }

}
