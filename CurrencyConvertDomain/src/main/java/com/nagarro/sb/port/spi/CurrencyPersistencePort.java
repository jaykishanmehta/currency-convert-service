package com.nagarro.sb.port.spi;

import java.util.Collection;

import com.nagarro.sb.data.CurrencyDto;

public interface CurrencyPersistencePort {

	Collection<CurrencyDto> findAll();
	
}
