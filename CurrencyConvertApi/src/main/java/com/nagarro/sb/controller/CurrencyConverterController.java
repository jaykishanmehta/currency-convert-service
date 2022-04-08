package com.nagarro.sb.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.exception.RatesNotAvailableException;
import com.nagarro.sb.port.api.CacheManagerPort;
import com.nagarro.sb.port.api.RateConvertorServicePort;

@RestController(value = "/")
public class CurrencyConverterController {

	@Autowired
	private CacheManagerPort cacheManager;
	
	@Autowired
	private RateConvertorServicePort convertor;
	
	/**
	 * 
	 * @return List of available currencies
	 */
	@GetMapping(value = "/available-currencies")
	public ResponseEntity<Collection<CurrencyDto>> getCurrencies() {
		return ResponseEntity.of(Optional.of(cacheManager.getAvailableCurrencies()));
	}
	
	/**
	 * 
	 * @return List of available currencies
	 */
	@GetMapping(value = "/available-conversions")
	public ResponseEntity<Collection<CurrencyRatesDto>> getAvailableConversion() {
		return ResponseEntity.of(Optional.of(cacheManager.getAvailableCurrencyRates()));
	}
	
	/**
	 * 
	 * @param input User inputs
	 * @return Payload with converted value or error message
	 * @throws RatesNotAvailableException When rate is not available in application
	 */
	@PostMapping(value = "/convert-currency")
	public ResponseEntity<ConversionPayload> convertCurrency(@Valid @RequestBody ConversionPayload input) throws RatesNotAvailableException {
		convertor.convert(input);
		return ResponseEntity.ok(input);
	}
	
}
