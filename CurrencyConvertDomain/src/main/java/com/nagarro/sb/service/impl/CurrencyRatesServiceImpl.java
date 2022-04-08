package com.nagarro.sb.service.impl;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.port.api.CurrencyRatesServicePort;
import com.nagarro.sb.port.spi.CurrencyRatesPersistencePort;

public class CurrencyRatesServiceImpl implements CurrencyRatesServicePort {

	private CurrencyRatesPersistencePort currencyRatesPersistancePort;
	
	public CurrencyRatesServiceImpl(CurrencyRatesPersistencePort currencyRatesPersistence) {
		this.currencyRatesPersistancePort = currencyRatesPersistence;
	}

	@Override
	public Collection<CurrencyRatesDto> getAvailableConversionRates() {
		return currencyRatesPersistancePort.findAll();
	}

}
