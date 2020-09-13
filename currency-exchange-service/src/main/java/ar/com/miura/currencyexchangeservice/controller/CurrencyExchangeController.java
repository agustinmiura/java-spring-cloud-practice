package ar.com.miura.currencyexchangeservice.controller;

import ar.com.miura.currencyexchangeservice.domain.ExchangeValue;
import ar.com.miura.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CurrencyExchangeController {

    private static final Logger LOGGER =LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        var exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        LOGGER.debug(" The exchange value is : {} ", exchangeValue);
        return exchangeValue;
    }
}
