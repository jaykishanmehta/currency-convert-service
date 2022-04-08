package com.nagarro.sb.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.exception.RatesNotAvailableException;
import com.nagarro.sb.port.api.CacheManagerPort;
import com.nagarro.sb.port.api.RateConvertorServicePort;

@Service
public class RateConvertorServiceImpl implements RateConvertorServicePort {
	
	@Autowired
	private CacheManagerPort cacheManager;
	
	public void convert(ConversionPayload data) throws RatesNotAvailableException {
		Optional<CurrencyRatesDto> rate = cacheManager.findRates(data);
		
		if(!rate.isPresent()) {
			throw new RatesNotAvailableException ("Rate not found for " + data.getFrom() + " to " + data.getTo());
		}
		
		rate.ifPresent(t -> {
			double convertedAmount = data.getAmount() * rate.get().getRate();
			data.setConvertedToAmount(convertedAmount);
		});
	}
}
