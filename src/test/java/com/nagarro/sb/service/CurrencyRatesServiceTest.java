package com.nagarro.sb.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.sb.dao.CurrencyRatesRepository;
import com.nagarro.sb.pojo.CurrencyRates;
import com.nagarro.sb.service.impl.CurrencyRatesServiceImpl;

@ExtendWith(MockitoExtension.class)
class CurrencyRatesServiceTest {

	@Mock
	private CurrencyRatesRepository currencyRatesRepository;
	
	@Autowired
    @InjectMocks
    private CurrencyRatesServiceImpl currencyRatesService;
	
	@Test
	void testGetAvailableConversionRates() {
		Mockito.when(currencyRatesRepository.findAll()).thenReturn((Iterable<CurrencyRates>) getCurrencyRateList());
		assertTrue(currencyRatesService.getAvailableConversionRates().size() > 0);
	}

	private List<CurrencyRates> getCurrencyRateList() {
		List<CurrencyRates> list = new ArrayList<>();
		list.add(new CurrencyRates());
		return list;
	}

}
