package com.nagarro.sb.port.api;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyDto;

public interface CurrencyServicePort {

	Collection<CurrencyDto> getAvailableCurrencies();
	
}
