package com.nagarro.sb.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.sb.dao.CurrencyRepository;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.service.impl.CurrencyServiceImpl;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

	@Mock
	private CurrencyRepository currencyRepository;
	
	@Autowired
    @InjectMocks
    private CurrencyServiceImpl currencyService;
	
	@Test
	void testGetAvailableCurrencies() {
		
		Mockito.when(currencyRepository.findAll()).thenReturn((Iterable<Currency>) getCurrencyList());
		assertTrue(currencyService.getAvailableCurrencies().size() > 0);
	}

	private List<Currency> getCurrencyList() {
		List<Currency> currencyList = new ArrayList<>();
		currencyList.add(new Currency());
		return currencyList;
	}

}
