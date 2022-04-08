package com.nagarro.sb.port.api;

import java.util.Collection;
import java.util.Optional;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.data.CurrencyRatesDto;

public interface CacheManagerPort {

	/**
	 * Load required resources on start up
	 */
	void init();

	/**
	 * Finds available rate from the cached data
	 * 
	 * @param data contains from and to field
	 * @return
	 */
	Optional<CurrencyRatesDto> findRates(ConversionPayload data);

	Collection<CurrencyDto> getAvailableCurrencies();

	Collection<CurrencyRatesDto> getAvailableCurrencyRates();

}
