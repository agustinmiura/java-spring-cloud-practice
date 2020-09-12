package ar.com.miura.currencyconversionservice.proxy;

import ar.com.miura.currencyconversionservice.domain.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient(name="currency-exchange-service") : Call Feing client using Eureka service discovery.
 *                                       Requires : @GetMapping("/currency-exchange/from/{from}/to/{to}")
 * @RibbonClient(name="currency-exchange-service") : Call Using Ribbon client that needs the addresses of the services.
 *                                       Requires : @GetMapping("/currency-exchange/from/{from}/to/{to}")
 *
 */
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
