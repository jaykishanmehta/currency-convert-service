package com.nagarro.sb.port.spi;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyRatesDto;

public interface CurrencyRatesPersistencePort {

	Collection<CurrencyRatesDto> findAll();
}
