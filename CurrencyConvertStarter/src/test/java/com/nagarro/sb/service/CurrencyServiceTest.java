package com.nagarro.sb.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.port.spi.CurrencyPersistencePort;
import com.nagarro.sb.service.impl.CurrencyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CurrencyServiceTest {

	@Mock
	private CurrencyPersistencePort currencyPersistancePort;
	
	@Autowired
    @InjectMocks
    private CurrencyServiceImpl currencyService;
	
	@Test
	void testGetAvailableCurrencies() {
		
		Mockito.when(currencyPersistancePort.findAll()).thenReturn(getCurrencyList());
		assertTrue(currencyService.getAvailableCurrencies().size() > 0);
	}

	private Collection<CurrencyDto> getCurrencyList() {
		Collection<CurrencyDto> currencyList = new ArrayList<>();
		currencyList.add(new CurrencyDto());
		return currencyList;
	}

}
