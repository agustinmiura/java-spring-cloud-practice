package ar.com.miura.currencyexchangeservice.repository;

import ar.com.miura.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);

}
