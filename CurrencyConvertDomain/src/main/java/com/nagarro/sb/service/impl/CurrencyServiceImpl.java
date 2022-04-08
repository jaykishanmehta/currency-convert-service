package com.nagarro.sb.service.impl;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.port.api.CurrencyServicePort;
import com.nagarro.sb.port.spi.CurrencyPersistencePort;

public class CurrencyServiceImpl implements CurrencyServicePort {
	
	private CurrencyPersistencePort currencyPersistancePort;

	public CurrencyServiceImpl(CurrencyPersistencePort currencyPersistence) {
		this.currencyPersistancePort = currencyPersistence;
	}

	@Override
	public Collection<CurrencyDto> getAvailableCurrencies() {
		return currencyPersistancePort.findAll();
	}
	
	
}
