package com.nagarro.sb.port.api;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyRatesDto;

public interface CurrencyRatesServicePort {

	Collection<CurrencyRatesDto> getAvailableConversionRates();

}
