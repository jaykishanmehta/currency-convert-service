package com.nagarro.sb.service.impl;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.port.api.CacheManagerPort;
import com.nagarro.sb.port.api.CurrencyRatesServicePort;
import com.nagarro.sb.port.api.CurrencyServicePort;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CacheManagerServiceImpl implements CacheManagerPort {

	@Getter
	private Collection<CurrencyDto> availableCurrencies;
	
	@Getter
	private Collection<CurrencyRatesDto> availableCurrencyRates;
	
	@Autowired
	private CurrencyServicePort currencyServicePort;
	
	@Autowired
	private CurrencyRatesServicePort currencyRatesServicePort;
	
	@Override
	@PostConstruct
	public void init() {
		availableCurrencies = currencyServicePort.getAvailableCurrencies();
		
		log.info("Currencies loaded: {} ", availableCurrencies);
		
		availableCurrencyRates = currencyRatesServicePort.getAvailableConversionRates();
		
		log.info("Available conversions: {}", availableCurrencyRates);
		
		log.info("Loaded currencies {} and available rates {}", availableCurrencies.size(), availableCurrencyRates.size());
		
	}

	/**
	 * Finds available rate from the cached data
	 * 
	 * @param data contains from and to field
	 * @return
	 */
	@Override
	public Optional<CurrencyRatesDto> findRates(ConversionPayload data) {
		return availableCurrencyRates.stream().filter(t-> t.getFromCurrency().getCode().equals(data.getFrom()) && t.getToCurrency().getCode().equals(data.getTo())).findAny();
	}
	
}
